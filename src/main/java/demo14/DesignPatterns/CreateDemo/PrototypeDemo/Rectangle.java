package demo14.DesignPatterns.CreateDemo.PrototypeDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/18  15:21
 */
public class Rectangle extends Shape {

    public Rectangle(){
        type = "Rectangle";
    }

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
