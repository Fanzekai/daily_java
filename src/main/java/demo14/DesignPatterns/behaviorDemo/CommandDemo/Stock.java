package demo14.DesignPatterns.behaviorDemo.CommandDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/21  23:28
 */
public class Stock {

    private String name = "ABC";
    private int quantity = 10;

    public void buy(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
    }
    public void sell(){
        System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
    }
}
