package demo14.DesignPatterns.behaviorDemo.TemplateDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  16:06
 */
//模板
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //模板
    public final void play(){

        //初始化游戏
        initialize();

        //开始游戏
        startPlay();

        //结束游戏
        endPlay();
    }
}
