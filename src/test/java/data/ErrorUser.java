package data;

public enum ErrorUser {

    LOCKED("locked_out_user"),
    INVALID("invalid_login_user");

    public final String login;
    public final String password = "secret_sauce";

    ErrorUser(String login) {
        this.login = login;
    }

}
