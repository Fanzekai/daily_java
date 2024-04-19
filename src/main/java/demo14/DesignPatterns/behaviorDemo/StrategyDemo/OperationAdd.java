package demo14.DesignPatterns.behaviorDemo.StrategyDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  16:04
 */
public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
