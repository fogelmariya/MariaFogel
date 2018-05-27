package enums;

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
