package demo01.lamdaDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  9:32
 */
public class lamdademo3 {

        public static void main(String[] args) {
            //4.局部内部类
            class Like12 implements ILike {
                @Override
                public void lamda() {
                    System.out.println("I like lamda2");
                }
            }
            ILike like = new Like12();
            like.lamda();
        }
    }


