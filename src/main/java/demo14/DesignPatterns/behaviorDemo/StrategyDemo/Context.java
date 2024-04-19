package demo14.DesignPatterns.behaviorDemo.StrategyDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  16:04
 */
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
