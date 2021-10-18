package agent;

import behaviour.Behaviour;
import message.handler.MessageHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class SimpleAutonomousAgent extends GenericAutonomousAgent implements Runnable {

    public static final String DELIMITER = "/";

    public SimpleAutonomousAgent(String name, List<String> localMemory, List<MessageHandler> messageHandlers,
                                 List<Behaviour> behaviours, BlockingQueue<String> inBoxMessages, BlockingQueue<String> outBoxMessages) {
        super(name, localMemory, messageHandlers, behaviours, inBoxMessages, outBoxMessages);
    }

    public void run() {

        while (true) {

            handleIncomingMessages();

            List<String> resultsFromBehaviours = expressBehaviours();

            if(resultsFromBehaviours!=null){
                sendResultsToOutBox(resultsFromBehaviours);
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void handleIncomingMessages() {
        while ((getInBoxMessages().peek()) != null) {

            if(getMessageHandlers()!=null){
                getMessageHandlers().forEach(messageHandler -> {

                    System.out.println(this.getName() + ": is handling messages. Messages: " + getInBoxMessages().peek());
                    messageHandler.handleMessage(getInBoxMessages().poll());

                });
            }

        }
    }

    private void sendResultsToOutBox(List<String> resultsFromBehaviours) {
        StringBuffer aggregatedResultsFromBehaviours = new StringBuffer();

        for (String resultFromBehaviour : resultsFromBehaviours) {
            aggregatedResultsFromBehaviours.append(resultFromBehaviour + DELIMITER);
        }
        try {
            this.getOutBoxMessages().put(aggregatedResultsFromBehaviours.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private List<String> expressBehaviours() {
        if(getBehaviours()!=null){
            List<String> resultsFromBehaviours = new ArrayList<>();
            for (Behaviour behaviour : getBehaviours()) {
                List<String> strings = behaviour.expressBehaviour(getLocalMemory());
                System.out.println(this.getName() + ": is expressing behaviours. Results: " + strings.toString());
                resultsFromBehaviours.addAll(strings);
            }
            return resultsFromBehaviours;
        }
       return null;
    }

    public void activateBehaviour(String behaviour) {

    }

    public void activateAllBehaviours() {

    }

    public void testPurposesAutonomousAgentActions(){
        handleIncomingMessages();

        List<String> resultsFromBehaviours = expressBehaviours();

        if(resultsFromBehaviours!=null){
            sendResultsToOutBox(resultsFromBehaviours);
        }
    }
}