package demo07.MQ.pojo;

import java.io.Serializable;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/15  16:05
 */


public class User implements Serializable {
    public String name;
    public String password;
    // 省略get和set方法

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
