package entities;

import com.epam.commons.DataClass;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class User extends DataClass {
    public static User PETER = new User("epam", "1234", "PETER");

    String login;
    String password;
    String name;
}

