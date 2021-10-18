package agent;

import behaviour.Behaviour;
import message.handler.MessageHandler;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public abstract class GenericAutonomousAgent implements AutonomousAgentInterface {

    private String name;
    private List<String> localMemory;
    private List<MessageHandler> messageHandlers;
    private List<Behaviour> behaviours;
    private BlockingQueue<String> inBoxMessages;
    private BlockingQueue<String> outBoxMessages;

    protected GenericAutonomousAgent(String name, List<String> localMemory, List<MessageHandler> messageHandlers,
                                  List<Behaviour> behaviours, BlockingQueue<String> inBoxMessages, BlockingQueue<String> outBoxMessages) {
        this.name = name;
        this.localMemory = localMemory;
        this.messageHandlers = messageHandlers;
        this.behaviours = behaviours;
        this.inBoxMessages = inBoxMessages;
        this.outBoxMessages = outBoxMessages;
    }

    public String getName() {
        return name;
    }

    public BlockingQueue<String> getInBoxMessages() {
        return inBoxMessages;
    }

    public void setInBoxMessages(BlockingQueue<String> inBoxMessages) {
        this.inBoxMessages = inBoxMessages;
    }

    public BlockingQueue<String> getOutBoxMessages() {
        return outBoxMessages;
    }

    public void setOutBoxMessages(BlockingQueue<String> outBoxMessages) {
        this.outBoxMessages = outBoxMessages;
    }

    public List<String> getLocalMemory() {
        return localMemory;
    }

    public void setLocalMemory(List<String> localMemory) {
        this.localMemory = localMemory;
    }

    public List<MessageHandler> getMessageHandlers() {
        return messageHandlers;
    }

    public void setMessageHandlers(List<MessageHandler> messageHandlers) {
        this.messageHandlers = messageHandlers;
    }

    public List<Behaviour> getBehaviours() {
        return behaviours;
    }

    public void setBehaviours(List<Behaviour> behaviours) {
        this.behaviours = behaviours;
    }
}
