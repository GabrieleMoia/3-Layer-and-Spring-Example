package WebService.bus;

public interface Bus {
    <T> void register(Class<T> clazz,
                      MessageConsumer consumer);
    void send(BusMessage message);
}
