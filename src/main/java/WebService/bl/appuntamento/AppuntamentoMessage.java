package WebService.bl.appuntamento;

import WebService.bus.BusMessage;

public class AppuntamentoMessage implements BusMessage {
    boolean utenteAddedDeleted;

    public AppuntamentoMessage(boolean utenteAddedDeleted) {
        this.utenteAddedDeleted = utenteAddedDeleted;
    }

    public boolean getUtenteAddedDeleted() {
        return utenteAddedDeleted;
    }

    public void setUtenteAddedDeleted(boolean utenteAddedDeleted) {
        this.utenteAddedDeleted = utenteAddedDeleted;
    }
}
