package demo14.DesignPatterns.behaviorDemo.TemplateDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  16:06
 */
public class Cricket extends Game {

    @Override
    void endPlay() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void initialize() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}
