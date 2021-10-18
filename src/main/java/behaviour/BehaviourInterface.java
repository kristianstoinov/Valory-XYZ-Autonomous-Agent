package behaviour;

import java.util.Collection;
import java.util.List;

public interface BehaviourInterface {

    List<String> expressBehaviour(List<String> input);

    void expressBehaviour(Object input);

    void expressBehaviour(Collection<Object> input);

    void expressBehaviour();
}
