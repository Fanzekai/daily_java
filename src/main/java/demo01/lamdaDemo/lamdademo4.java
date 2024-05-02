package demo01.lamdaDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  9:32
 */
public class lamdademo4 {

    public static void main(String[] args) {
        //6.lamda简化
        ILike like = () ->{
            System.out.println("I like lamda4");
        };
        like.lamda();
    }

}
