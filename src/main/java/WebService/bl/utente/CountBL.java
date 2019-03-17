package WebService.bl.utente;

import WebService.bus.MessageConsumer;

public interface CountBL extends MessageConsumer {
    int countEnabled();
}
