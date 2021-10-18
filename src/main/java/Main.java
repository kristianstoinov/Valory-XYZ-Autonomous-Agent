import agent.SimpleAutonomousAgent;
import behaviour.Behaviour;
import behaviour.GenerateRandom2WordBehaviour;
import message.handler.FilterByWordMessageHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Main {
    public static void main(String[] args) {

        ArrayList<String> localMemoryForAgents =
                new ArrayList<>(Arrays.asList("hello", "sun", "world", "space", "moon", "crypto", "sky", "ocean", "universe", "human"));

        FilterByWordMessageHandler messageHandler1 = new FilterByWordMessageHandler();
        messageHandler1.setWordToBeFilteredBy("hello");

        FilterByWordMessageHandler messageHandler2 = new FilterByWordMessageHandler();
        messageHandler2.setWordToBeFilteredBy("hello");

        Behaviour behaviour1 = new GenerateRandom2WordBehaviour();
        Behaviour behaviour2 = new GenerateRandom2WordBehaviour();

        BlockingQueue<String> inBoxMessagesAgent1OutBoxAgent2 = new LinkedBlockingQueue<>();
        BlockingQueue<String> inBoxMessagesAgent2OutBoxAgent1 = new LinkedBlockingQueue<>();

        Thread autonomousAgent1Thread =
                new Thread(
                        new SimpleAutonomousAgent("Agent - 1", localMemoryForAgents, Collections.singletonList(messageHandler1),
                                Collections.singletonList(behaviour1), inBoxMessagesAgent1OutBoxAgent2, inBoxMessagesAgent2OutBoxAgent1));

        Thread autonomousAgent2Thread =
                new Thread(
                        new SimpleAutonomousAgent("Agent - 2", localMemoryForAgents, Collections.singletonList(messageHandler2),
                                Collections.singletonList(behaviour2), inBoxMessagesAgent2OutBoxAgent1, inBoxMessagesAgent1OutBoxAgent2));

        autonomousAgent1Thread.start();
        autonomousAgent2Thread.start();

    }
}