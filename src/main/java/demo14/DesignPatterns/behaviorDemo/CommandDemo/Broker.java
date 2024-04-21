package demo14.DesignPatterns.behaviorDemo.CommandDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/21  23:29
 */
import java.util.ArrayList;
import java.util.List;

public class Broker {
    private List<Order> orderList = new ArrayList<Order>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
