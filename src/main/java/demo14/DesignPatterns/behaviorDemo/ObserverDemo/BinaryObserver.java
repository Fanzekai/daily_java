package demo14.DesignPatterns.behaviorDemo.ObserverDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  15:42
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: "
                + Integer.toBinaryString( subject.getState() ) );
    }
}
