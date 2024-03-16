package demo08;

import java.util.List;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/3/16  10:04
 */
public class User {

    private String UserName;

    private String Password;

    private String UserInfo;

    private List<User> Friends;

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getUserInfo() {
        return UserInfo;
    }

    public void setUserInfo(String userInfo) {
        UserInfo = userInfo;
    }

    public List getFriends() {
        return Friends;
    }

    public void setFriends(List friends) {
        Friends = friends;
    }
}
