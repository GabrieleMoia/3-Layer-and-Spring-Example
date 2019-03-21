package WebService.bl.count.countAppuntamenti;

import WebService.bus.Bus;
import WebService.bus.BusMessage;
import WebService.dl.count.appuntamento.CountAppuntamentiDL;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.inject.Named;
@Named("CountAppuntamentiBL")
@Component
public class CountAppuntamentiMqBus extends CountAppuntamentiBLImpl {

    public CountAppuntamentiMqBus(@Named("CountAppuntamentiDL") CountAppuntamentiDL countAppuntamentiDL,
                            @Named("busAppuntamento") Bus bus) {
        super(countAppuntamentiDL, bus);
    }

    @JmsListener(
            destination = "appuntamenti_utente", //nome della coda dove invia i messaggi
            containerFactory = "queueListenerFactory", //dichiarazione del listener dove legge i messaggi
            selector = "classtype = 'UtenteMessage'") //tipo di messaggio restituito
    public void handle(AppuntamentoMessage messageType) throws Exception {
        super.handle((BusMessage)messageType);
    }
}

