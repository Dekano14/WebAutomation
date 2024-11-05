package utils;

public class Credentials {

    //Users
    private String user = "Admin";
    private String password = "admin123";

    //New Password
    private String newPassword = "Le@ndro809";

    //Users fails
    private String userfail = "Amin";
    private String passfail = "admin";

    public Credentials() {
        this.user = user;
        this.password = password;
        this.newPassword = newPassword;
        this.userfail = userfail;
        this.passfail = passfail;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getUserfail() {
        return userfail;
    }

    public String getPassfail() {
        return passfail;
    }
}
