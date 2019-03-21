package WebService.bus.jms;

import WebService.bus.Bus;
import WebService.bus.BusMessage;
import WebService.bus.MessageConsumer;
import org.springframework.jms.core.JmsTemplate;

import javax.inject.Named;

@Named("bus")
public class UtentiEnabledMQ implements Bus { //implementa la classe bus per ereditare i metodi register e send

    private JmsTemplate jmsQueTemplate;

    //ignetto il metodo jmsQueueTemplate che è il nome del metodo nella classe jmsConfiguration con cui invio i messaggi (in questo caso alla coda)
    public UtentiEnabledMQ(@Named("jmsQueueTemplate") JmsTemplate jmsQueTemplate) {
        this.jmsQueTemplate = jmsQueTemplate;
    }

    @Override
    public <T> void register(Class<T> clazz, MessageConsumer consumer) {

    }

    @Override
    public void send(BusMessage message) {
        jmsQueTemplate.convertAndSend("utenti_enabled", message, m -> { //nome della coda dove invio i messaggi
            m.setStringProperty("classtype",
                    message.getClass().getSimpleName()); //nome della classe del messaggio inviato
            return m;
        });
    }

}

