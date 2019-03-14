package WebService.bl;

import WebService.bus.MessageConsumer;

public interface CountBL extends MessageConsumer {
    int countEnabled();
}
