package message.handler;

public abstract class MessageHandler implements MessageHandlerInterface{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}