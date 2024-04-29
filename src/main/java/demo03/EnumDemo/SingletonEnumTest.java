package demo03.EnumDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/1/25  17:16
 */
public class SingletonEnumTest {
    public enum SingletonEnum {
        fzk;
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        SingletonEnum.fzk.setName("jay@huaxiao");
        System.out.println(SingletonEnum.fzk.getName());
    }
}
