package entities;

import com.epam.commons.DataClass;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User extends DataClass {
    public String login;
    public String password;

//    public User(String login, String password){
//        this.login = login;
//        this.password = password;
//    }

    public User() {
        this.login = "epam";
        this.password = "1234";
    }
}
