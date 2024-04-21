package demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo;

import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.Factory.AbstractFactory;
import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.Factory.ColorFactory;
import demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.Factory.ShapeFactory;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/21  23:36
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if(choice.equalsIgnoreCase("SHAPE")){
            return new ShapeFactory();
        } else if(choice.equalsIgnoreCase("COLOR")){
            return new ColorFactory();
        }
        return null;
    }
}
