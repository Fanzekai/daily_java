package demo01.AopDemo.dmeo01;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/18  9:21
 */
public class UserService {
    public String getUserById(int id) {
        System.out.println("Executing getUserById with id: " + id);
        return "User" + id;
    }
}
