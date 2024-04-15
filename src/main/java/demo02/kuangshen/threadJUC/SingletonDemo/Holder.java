package demo02.kuangshen.threadJUC.SingletonDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  16:53
 */
public class Holder {



    private Holder() {
    }

    private static Holder getInstance() {
        return InnerClass.HOLDER;
    }

    public static class InnerClass {
        private static final Holder HOLDER = new Holder();
    }
}
