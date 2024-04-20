package demo14.DesignPatterns.StructuralDemo.FacadeDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/20  22:52
 */
public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawCircle();
        shapeMaker.drawRectangle();
        shapeMaker.drawSquare();
    }
}
