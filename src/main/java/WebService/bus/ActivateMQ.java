package WebService.bus;

import org.springframework.jms.core.JmsTemplate;

import javax.inject.Named;

@Named("bus")
public class ActivateMQ implements Bus {

    private JmsTemplate jmsQueTemplate;

    public ActivateMQ(@Named("jmsQueueTemplate") JmsTemplate jmsQueTemplate) {
        this.jmsQueTemplate = jmsQueTemplate;
    }

    @Override
    public <T> void register(Class<T> clazz, MessageConsumer consumer) {

    }

    @Override
    public void send(BusMessage message) {
        jmsQueTemplate.convertAndSend("utenti_enabled", message, m -> {
            m.setStringProperty("classtype",
                    message.getClass().getSimpleName());
            return m;
        });
    }

}

