package demo14.DesignPatterns.behaviorDemo.ObserverDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  15:42
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: "
                + Integer.toOctalString( subject.getState() ) );
    }
}
