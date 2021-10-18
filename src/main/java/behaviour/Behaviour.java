package behaviour;

public abstract class Behaviour implements BehaviourInterface {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}