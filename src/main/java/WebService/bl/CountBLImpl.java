package WebService.bl;

import WebService.bus.Bus;
import WebService.bus.BusMessage;
import WebService.dl.CountDL;
import WebService.pl.Utente;

import javax.inject.Named;

@Named("CountBL")
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
