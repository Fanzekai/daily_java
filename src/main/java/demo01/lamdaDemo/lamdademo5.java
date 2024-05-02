package demo01.lamdaDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  9:34
 */
public class lamdademo5 {

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
