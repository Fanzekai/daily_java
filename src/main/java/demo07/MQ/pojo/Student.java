package demo07.MQ.pojo;

import java.io.Serializable;

/**
 * @author fzk
 * @version 1.0
 * @date 2023/11/16  11:19
 */
public class Student implements Serializable {

    public String name;
    public String password;


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getName() {
        return name;
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
