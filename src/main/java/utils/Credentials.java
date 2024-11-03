package utils;

public class Credentials {

    private String user = "Admin";
    private String password = "admin123";

    public Credentials(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}
