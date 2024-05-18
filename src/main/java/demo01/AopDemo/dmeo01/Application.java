package demo01.AopDemo.dmeo01;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/5/18  8:58
 */
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "demo01.AopDemo.dmeo01")
public class Application {

    public static void main(String[] args) {


        UserService userService = new UserService();
        userService.getUserById(1);
    }
}
