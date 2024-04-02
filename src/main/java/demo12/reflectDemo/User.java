package demo12.reflectDemo;

/**
 * @author fzk
 * @version 1.0
 * @date 2024/4/2  17:41
 */

public class User{
    // Field
    int no;

    // Constructor
    public User(){

    }
    public User(int no){
        this.no = no;
    }

    // Method
    public void setNo(int no){
        this.no = no;
    }
    public int getNo(){
        return no;
    }


}
