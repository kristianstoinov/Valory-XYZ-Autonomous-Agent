package behaviour;

import java.util.*;

public class GenerateRandom2WordBehaviour extends Behaviour {

    @Override
    public List<String> expressBehaviour(List<String> inputAlphabet) {
        return this.generateRandom2WordMessagesFromAlphabet(inputAlphabet);
    }

    @Override
    public void expressBehaviour(Object input) {
        //  empty method, displays the flexibility of the interface
    }

    @Override
    public void expressBehaviour(Collection<Object> input) {
//  empty method, displays the flexibility of the interface
    }

    @Override
    public void expressBehaviour() {
//  empty method, displays the flexibility of the interface
    }

    private List<String> generateRandom2WordMessagesFromAlphabet(List<String> inputAlphabet) {

        Random r = new Random();
        String firstRandomWord = inputAlphabet.get(r.nextInt(inputAlphabet.size()));
        String secondRandomWord = inputAlphabet.get(r.nextInt(inputAlphabet.size()));

//        System.out.println("Generated - " + firstRandomWord + " / " + secondRandomWord);
        return new ArrayList<>(Arrays.asList(firstRandomWord, secondRandomWord));
    }

}
