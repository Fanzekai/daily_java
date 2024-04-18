package demo14.DesignPatterns.CreateDemo.PrototypeDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  15:22
 */
public class Circle extends Shape {

    public Circle(){
        type = "Circle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
