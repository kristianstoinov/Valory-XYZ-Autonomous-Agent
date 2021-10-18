package message.handler;

public interface MessageHandlerInterface {

    void handleMessage(String input);

    void handleMessage(Object input);
}
