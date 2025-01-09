package demo01.streamDemo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/14  14:42
 */
public class test {


        public static void main(String[] args) {
            User user1 = new User(1,21,"张三");
            User user2 = new User(2,23,"李四");
            User user3 = new User(3,29,"王五");
            User user4 = new User(4,21,"赵六");
            //集合存储
            List<User> userList = Arrays.asList(user1, user2, user3, user4);
            //计算交给流
            userList.stream().filter(user -> {return user.getId()%2==0;})
                    .filter(user -> {return user.getAge()>20;})
                    .map(user -> {return user.getName().toUpperCase(Locale.ROOT);})
                    .sorted((u1,u2)->{return u2.compareTo(u1); })
                    .limit(1)//分页
                    .forEach(System.out::println);

        }
    }

@Data
@NoArgsConstructor
@AllArgsConstructor
class User{

    private  int id;
    private  int age;
    private  String name;
}
