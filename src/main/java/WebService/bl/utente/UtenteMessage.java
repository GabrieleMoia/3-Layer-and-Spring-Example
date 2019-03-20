package WebService.bl.utente;

import WebService.bus.BusMessage;

public class UtenteMessage implements BusMessage {

    public boolean enabled;

    public UtenteMessage(){

    }

    public UtenteMessage(boolean enabled){
        this.enabled=enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
