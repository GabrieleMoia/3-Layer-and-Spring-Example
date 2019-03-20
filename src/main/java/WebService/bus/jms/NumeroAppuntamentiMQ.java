package WebService.bus.jms;

import WebService.bus.Bus;
import WebService.bus.BusMessage;
import WebService.bus.MessageConsumer;
import org.springframework.jms.core.JmsTemplate;

import javax.inject.Named;

@Named("busAppuntamento")
public class NumeroAppuntamentiMQ implements Bus {

    private JmsTemplate jmsQueTemplate;

    //ignetto il metodo jmsQueueTemplate che è il nome del metodo nella classe jmsConfiguration con cui invio i messaggi (in questo caso alla coda)
    public NumeroAppuntamentiMQ(@Named("jmsQueueTemplate") JmsTemplate jmsQueTemplate) {
        this.jmsQueTemplate = jmsQueTemplate;
    }

    @Override
    public <T> void register(Class<T> clazz, MessageConsumer consumer) {

    }

    @Override
    public void send(BusMessage message) {
        jmsQueTemplate.convertAndSend("appuntamenti_utente", message, m -> { //nome della coda dove invio i messaggi
            m.setStringProperty("classtype",
                    message.getClass().getSimpleName()); //nome della classe del messaggio inviato
            return m;
        });
    }
}
