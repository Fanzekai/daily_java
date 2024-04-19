package demo14.DesignPatterns.behaviorDemo.ObserverDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  15:42
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
