package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public enum Users{
    PITER_CHAILOVSKII("PITER CHAILOVSKII", "epam", "1234");

    private String userName;
    private String login;
    private String password;

}
