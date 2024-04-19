package demo14.DesignPatterns.behaviorDemo.StrategyDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  16:04
 */
public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}


//在策略模式定义了一系列算法或策略，并将每个算法封装在独立的类中，使得它们可以互相替换。
// 通过使用策略模式，可以在运行时根据需要选择不同的算法，而不需要修改客户端代码
