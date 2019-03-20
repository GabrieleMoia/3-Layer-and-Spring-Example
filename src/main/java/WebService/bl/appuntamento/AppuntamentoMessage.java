package WebService.bl.appuntamento;

import WebService.bus.BusMessage;

public class AppuntamentoMessage implements BusMessage {
    int idUtente;

    public AppuntamentoMessage(int idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }
}
