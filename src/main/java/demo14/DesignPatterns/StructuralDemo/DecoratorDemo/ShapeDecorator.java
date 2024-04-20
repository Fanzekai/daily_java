package demo14.DesignPatterns.StructuralDemo.DecoratorDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/20  22:53
 */
public abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public ShapeDecorator(Shape decoratedShape){
        this.decoratedShape = decoratedShape;
    }

    public void draw(){
        decoratedShape.draw();
    }
}
