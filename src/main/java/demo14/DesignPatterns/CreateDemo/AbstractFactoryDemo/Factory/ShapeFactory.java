package demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.Factory;

import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.colorImpl.Color;
import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.shapeImpl.Circle;
import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.shapeImpl.Rectangle;
import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.shapeImpl.Shape;
import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.shapeImpl.Square;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/21  23:36
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        } else if(shapeType.equalsIgnoreCase("SQUARE")){
            return new Square();
        }
        return null;
    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
