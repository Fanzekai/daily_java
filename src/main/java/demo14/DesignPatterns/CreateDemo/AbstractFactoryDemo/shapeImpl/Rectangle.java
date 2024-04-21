package demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.shapeImpl;

import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.shapeImpl.Shape;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/21  23:34
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
