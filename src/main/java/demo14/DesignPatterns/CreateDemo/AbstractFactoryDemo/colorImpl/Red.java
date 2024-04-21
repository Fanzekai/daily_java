package demo14.DesignPatterns.CreateDemo.AbstractFactoryDemo.colorImpl;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/21  23:35
 */
public class Red implements Color {

    @Override
    public void fill() {
        System.out.println("Inside Red::fill() method.");
    }
}
