package WebService.bl.count.countAppuntamenti;

import WebService.bus.MessageConsumer;

public interface CountAppuntamentiBL extends MessageConsumer {
    int countAppuntamentiPerUtente(int idUtente) throws Exception;
}
