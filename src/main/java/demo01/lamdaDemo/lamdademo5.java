package demo01.lamdaDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  9:34
 */
public class lamdademo5 {

    /**
     * 主方法，程序的入口点。
     *
     * @param args 命令行参数，此处未使用。
     *
     * 在这个方法中，我们演示了如何使用Lambda表达式来简化接口的实现。
     * 1. 首先，我们定义了一个Lambda表达式，它实现了ILove接口中的方法，并接受一个int类型的参数a。
     * 2. 接着，我们对Lambda表达式进行了三次简化，展示了如何逐步减少代码的冗余。
     * 3. 在每次简化中，我们都移除了不必要的类型声明和括号，使得代码更加简洁。
     * 4. 最后，我们总结了Lambda表达式简化的规则，并调用了love对象的love方法，传入参数520。
     *
     * 注意：
     * - Lambda表达式的简化规则是，如果Lambda体只有一行代码，可以省略大括号{}、return关键字和参数类型（如果编译器可以推断出参数类型）。
     * - Lambda表达式只能用于函数式接口（即只有一个抽象方法的接口）。
     * - 如果Lambda表达式有多个参数，可以省略参数类型，但必须省略所有参数的类型，并且必须保留括号()。
     */
    public static void main(String[] args) {
        // 1.lamda
        ILove love = (int a) -> {
            System.out.println("I love you -->" + a);
        };
        // 2.lamda简化1.0
        love = (a) -> {
            System.out.println("I love you -->" + a);
        };
        // 3.lamda简化2.0
        love = a -> {
            System.out.println("I love you -->" + a);
        };
        // 3.lamda简化3.0
        love = a -> System.out.println("I love you -->" + a);

        /**总结:
         * {}简略的条件是只能有一行代码,多行{}就不能简略了
         * 前提是接口为函数式接口(只能有一个方法)
         * 多个参数也可以去掉参数类型,要去掉就都去掉,必须加上()
         */

        love.love(520);
    }
}

interface ILove {
    void love(int a);
}
