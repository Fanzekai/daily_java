package demo01.Abstractclasses;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/15  20:23
 */
public class Dog extends Animal{

    public Dog(String name ){
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("狗吃肉");
    }

    public static void main(String[] args) {
        Dog dog = new Dog("哈士奇");
        dog.sleep();
    }
}



