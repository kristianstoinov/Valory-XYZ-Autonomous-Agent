package message.handler;

import java.util.Arrays;
import java.util.Objects;

public class FilterByWordMessageHandler extends MessageHandler {

    public static final String DELIMITER = "/";

    private String wordToBeFilteredBy;

    @Override
    public void handleMessage(String input) {
        this.filterForWordAndPrintTheWholeMessage(input);
    }

    @Override
    public void handleMessage(Object input) {
//  empty method, displays the flexibility of the interface
    }


    private void filterForWordAndPrintTheWholeMessage(String messages) {
        if(!messages.isEmpty() && messages!=null){
            String[] strings = messages.split(DELIMITER);
            boolean wordIsFound = Arrays.stream(strings).anyMatch(x -> Objects.equals(x, wordToBeFilteredBy));
            if (wordIsFound == true) {
                System.out.println("Match found. Printing whole message.");
                System.out.println(messages);
            }
        }
    }

    public String getWordToBeFilteredBy() {
        return wordToBeFilteredBy;
    }

    public void setWordToBeFilteredBy(String wordToBeFilteredBy) {
        this.wordToBeFilteredBy = wordToBeFilteredBy;
    }
}
