package demo14.DesignPatterns.behaviorDemo.CommandDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/21  23:29
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    public void execute() {
        abcStock.sell();
    }
}
