package utils;

public class Helpers {

    private String urlWeb = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";


    public Helpers(String urlWeb) {
        this.urlWeb = urlWeb;
    }

    public String getUrlWeb() {
        return urlWeb;
    }
}
