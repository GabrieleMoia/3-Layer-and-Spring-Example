package WebService.bl.count.countUtentiEnabled;

import WebService.bus.MessageConsumer;

public interface CountBL extends MessageConsumer {
    int countEnabled();
}
