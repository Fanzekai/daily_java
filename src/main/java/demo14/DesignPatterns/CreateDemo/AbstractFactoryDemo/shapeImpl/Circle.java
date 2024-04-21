package demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.shapeImpl;

import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.shapeImpl.Shape;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/21  23:35
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
