package demo14.DesignPatterns.CreateDemo.BuilderPattern;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/23  19:56
 */
public class Builder1 extends Builder {


    Product product = new Product();


    @Override
    public void BuildPart() {

        product.Add("A");
        product.Add("B");
        product.Add("C");
        product.Add("D");
        product.Add("E");
        product.Add("F");
    }

    @Override
    public Product getResult() {

        return product;
    }
}




