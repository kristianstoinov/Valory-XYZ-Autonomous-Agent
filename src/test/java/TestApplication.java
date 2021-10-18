import agent.SimpleAutonomousAgent;
import message.handler.FilterByWordMessageHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class TestApplication {


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;


    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    public void messageHandlerShouldPrintProperMessage() {
        FilterByWordMessageHandler messageHandler = new FilterByWordMessageHandler();
        messageHandler.setWordToBeFilteredBy("hello");

        messageHandler.handleMessage("ocean/hello/");

        assertEquals("Match found. Printing whole message.\r\nocean/hello/\r\n", outContent.toString());

    }

    @Test
    public void integrationTest() throws InterruptedException {
        ArrayList<String> localMemoryForAgents =
                new ArrayList<>(Arrays.asList("hello", "sun", "world", "space", "moon", "crypto", "sky", "ocean", "universe", "human"));

        FilterByWordMessageHandler messageHandler1 = new FilterByWordMessageHandler();
        messageHandler1.setWordToBeFilteredBy("hello");

        FilterByWordMessageHandler messageHandler2 = new FilterByWordMessageHandler();
        messageHandler2.setWordToBeFilteredBy("hello");

        BlockingQueue<String> inBoxMessagesAgent1OutBoxAgent2 = new LinkedBlockingQueue<>();
        BlockingQueue<String> inBoxMessagesAgent2OutBoxAgent1 = new LinkedBlockingQueue<>();
        inBoxMessagesAgent1OutBoxAgent2.put("world/sky");
        inBoxMessagesAgent2OutBoxAgent1.put("crypto/hello");

        SimpleAutonomousAgent simpleAutonomousAgent1 = new SimpleAutonomousAgent("Agent - 1", localMemoryForAgents, Collections.singletonList(messageHandler1),
                null, inBoxMessagesAgent1OutBoxAgent2, inBoxMessagesAgent2OutBoxAgent1);

        SimpleAutonomousAgent simpleAutonomousAgent2 = new SimpleAutonomousAgent("Agent - 2", localMemoryForAgents, Collections.singletonList(messageHandler2),
                null, inBoxMessagesAgent2OutBoxAgent1, inBoxMessagesAgent1OutBoxAgent2);

        simpleAutonomousAgent1.testPurposesAutonomousAgentActions();
        simpleAutonomousAgent2.testPurposesAutonomousAgentActions();

        assertEquals("Agent - 1: is handling messages. Messages: world/sky\r\n" +
                "Agent - 2: is handling messages. Messages: crypto/hello\r\n" +
                "Match found. Printing whole message.\r\ncrypto/hello\r\n", outContent.toString());
    }
}