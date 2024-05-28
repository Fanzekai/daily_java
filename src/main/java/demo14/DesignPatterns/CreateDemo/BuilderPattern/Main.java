package demo14.DesignPatterns.CreateDemo.BuilderPattern;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/23  20:06
 */
public class Main {

    public static void main(String[] args) {

        Director director = new Director();
        Builder1 builder1 = new Builder1();
        director.Construct(builder1);
        Product product = builder1.getResult();
        product.show();


        Builder2 builder2 = new Builder2();
        director.Construct(builder2);
        Product product1 = builder2.getResult();
        product1.show();
    }
}
