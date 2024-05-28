package demo14.DesignPatterns.CreateDemo.BuilderPattern;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/23  20:05
 */
public class Builder2 extends Builder {


    Product product = new Product();


    @Override
    public void BuildPart() {

        product.Add("A");
        product.Add("B");
        product.Add("C");

    }

    @Override
    public Product getResult() {

        return product;
    }
}
