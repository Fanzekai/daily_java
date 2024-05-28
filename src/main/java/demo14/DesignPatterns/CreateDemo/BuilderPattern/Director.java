package demo14.DesignPatterns.CreateDemo.BuilderPattern;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/23  20:05
 */
public class Director {

    public void Construct(Builder builder){
        builder.BuildPart();
    }
}
