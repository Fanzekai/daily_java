package demo14.DesignPatterns.CreateDemo.FactoryDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  14:35
 */
public class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
