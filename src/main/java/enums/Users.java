package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

// TODO do you read my comments ?

// TODO This might be a simple class, actually. What is the reason of enum here ?
// TODO Anyway, wrong class name
// TODO Lombok ? Basically, fields should be private...
@AllArgsConstructor
@Getter
public enum Users{
    PITER_CHAILOVSKII("PITER CHAILOVSKII", "epam", "1234");

    private String userName;
    private String login;
    private String password;

    // TODO I don't get it, you already have @Getter annotation,
    // TODO what is the reason of this ???
    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName(){
        return userName;
    }
    // !TODO
}
