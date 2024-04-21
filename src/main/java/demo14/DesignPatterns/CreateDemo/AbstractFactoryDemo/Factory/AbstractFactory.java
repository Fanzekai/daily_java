package demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.Factory;

import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.colorImpl.Color;
import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.shapeImpl.Shape;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/21  23:35
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
