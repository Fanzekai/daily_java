package demo14.DesignPatterns.behaviorDemo.StateDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  15:58
 */
public class StopState implements State {

    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    public String toString(){
        return "Stop State";
    }
}
