package demo14.DesignPatterns.behaviorDemo.StateDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  15:58
 */
public class Context {
    private State state;

    public Context(){
        state = null;
    }

    public void setState(State state){
        this.state = state;
    }

    public State getState(){
        return state;
    }
}
