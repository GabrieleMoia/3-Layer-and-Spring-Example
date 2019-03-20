package WebService.bl.count;

import WebService.bl.count.CountBL;
import WebService.bl.utente.UtenteMessage;
import WebService.bus.Bus;
import WebService.bus.BusMessage;
import WebService.dl.utente.CountDL;
import WebService.dl.utente.IUtenteDL;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.inject.Named;

public class CountBLImpl implements CountBL {
    private final CountDL countDL;

    public CountBLImpl(@Named("CountDL") CountDL countDL,
                       @Named("bus") Bus bus) {
        this.countDL = countDL;
        bus.register(UtenteMessage.class, this);
    }

    @Override
    public void handle(BusMessage messageType) throws Exception {
        UtenteMessage msg = (UtenteMessage) messageType;
        if (msg.isEnabled()) {
            countDL.incrementEnabled();
        } else {
            countDL.decrementEnabled();
        }
    }


    @Override
    public int countEnabled() {
        return countDL.getEnabled();
    }
}
