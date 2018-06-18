package enums;

// TODO This might be a simple class, actually. What is the reason of enum here ?
// TODO Anyway, wrong class name
// TODO Lombok ? Basically, fields should be private...
public enum Users {
    PITER_CHAILOVSKII("PITER CHAILOVSKII", "epam", "1234");

    public String userName;
    public String login;
    public String password;

    Users(String userName, String login, String password){
        this.userName = userName;
        this.login = login;
        this.password = password;
    }
}
