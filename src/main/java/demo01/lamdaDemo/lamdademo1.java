package demo01.lamdaDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  9:30
 */
public class lamdademo1 {

    public static void main(String[] args) {
        ILike like = new Like();
        like.lamda();
    }
}

// 1.定义一个函数式接口
interface ILike {
    void lamda();
}

// 2.实现类
class Like implements ILike {
    @Override
    public void lamda() {
        System.out.println("I like lamda");
    }
}
