package demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.Factory;

import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.colorImpl.Blue;
import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.colorImpl.Color;
import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.colorImpl.Green;
import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.colorImpl.Red;
import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.shapeImpl.Shape;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/21  23:36
 */
public class ColorFactory extends AbstractFactory {

    @Override
    public Shape getShape(String shapeType){
        return null;
    }

    @Override
    public Color getColor(String color) {
        if(color == null){
            return null;
        }
        if(color.equalsIgnoreCase("RED")){
            return new Red();
        } else if(color.equalsIgnoreCase("GREEN")){
            return new Green();
        } else if(color.equalsIgnoreCase("BLUE")){
            return new Blue();
        }
        return null;
    }
}
