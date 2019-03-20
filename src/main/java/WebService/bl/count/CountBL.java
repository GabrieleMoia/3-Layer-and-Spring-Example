package WebService.bl.count;

import WebService.bus.MessageConsumer;

public interface CountBL extends MessageConsumer {
    int countEnabled();
}
