package demo01.lamdaDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  9:31
 */
public class lamdademo2 {

    //3. 静态内部类
    static class Like1 implements ILike {
        @Override
        public void lamda() {
            System.out.println("I like lamda1");
        }
    }
    //3.静态内部类
    public static void main(String[] args) {
        ILike like = new Like1();
        like.lamda();
    }

}
