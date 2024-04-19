package demo14.DesignPatterns.behaviorDemo.StateDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  15:59
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        StartState startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        StopState stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }
}
