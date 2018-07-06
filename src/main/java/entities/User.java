package entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    public static User PETER = new User("epam", "1234", "PETER");

    String login;
    String password;
    String name;
}

