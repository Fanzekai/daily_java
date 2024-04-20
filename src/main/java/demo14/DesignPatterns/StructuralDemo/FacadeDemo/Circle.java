package demo14.DesignPatterns.StructuralDemo.FacadeDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/20  22:52
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
