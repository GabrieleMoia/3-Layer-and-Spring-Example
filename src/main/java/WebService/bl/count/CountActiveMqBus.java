package WebService.bl.count;

import WebService.bl.utente.UtenteMessage;
import WebService.bus.Bus;
import WebService.bus.BusMessage;
import WebService.dl.utente.CountDL;
import WebService.dl.utente.IUtenteDL;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.inject.Named;

@Named("CountBL")
@Component
public class CountActiveMqBus extends CountBLImpl {

    public CountActiveMqBus(@Named("CountDL") CountDL countDL,
                            @Named("bus") Bus bus) {
        super(countDL, bus);
    }

    @JmsListener(
            destination = "utenti_enabled", //nome della coda dove invia i messaggi
            containerFactory = "queueListenerFactory", //dichiarazione del listener dove legge i messaggi
            selector = "classtype = 'UtenteMessage'") //tipo di messaggio restituito
    public void handle(UtenteMessage messageType) throws Exception {
        super.handle((BusMessage)messageType);
    }
}


