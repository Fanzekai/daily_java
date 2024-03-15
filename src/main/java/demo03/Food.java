package demo03;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/1/25  17:01
 */
public interface Food {
    enum Coffee implements Food{
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
    }
    enum Dessert implements Food{
        FRUIT, CAKE, GELATO
    }
}
