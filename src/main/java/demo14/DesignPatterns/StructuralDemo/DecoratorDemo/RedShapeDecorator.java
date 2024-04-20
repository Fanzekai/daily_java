package demo14.DesignPatterns.StructuralDemo.DecoratorDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/20  22:53
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}
