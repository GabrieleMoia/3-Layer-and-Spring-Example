package WebService.bl.count.countAppuntamenti;

import WebService.bus.Bus;
import WebService.bus.BusMessage;
import WebService.dl.count.appuntamento.CountAppuntamentiDL;

import javax.inject.Named;

public class CountAppuntamentiBLImpl implements CountAppuntamentiBL {

    private final CountAppuntamentiDL countAppuntamentiDl;

    public CountAppuntamentiBLImpl(@Named("CountDLAppuntamento") CountAppuntamentiDL countAppuntamentiDl,
                                   @Named("busAppuntamento") Bus bus) {
        this.countAppuntamentiDl = countAppuntamentiDl;
    }

    @Override
    public void handle(BusMessage messageType) throws Exception {
        AppuntamentoMessage msg = (AppuntamentoMessage) messageType;
        countAppuntamentiDl.getNAppuntamenti(msg.getIdUtente());
    }

    @Override
    public int countAppuntamentiPerUtente(int id) throws Exception {
        return countAppuntamentiDl.getNAppuntamenti(id);
    }
}
