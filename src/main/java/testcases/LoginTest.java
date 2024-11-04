package testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Credentials;
import utils.Helpers;

import static org.openqa.selenium.By.cssSelector;


public class LoginTest {

    private ChromeDriver driver;
    private Credentials credentials;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        credentials = new Credentials();
        Helpers helpers = new Helpers();
        driver.get(helpers.getUrlWeb());
        driver.manage().window().maximize();

    }

    @Test
    public void loginSuccess(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(credentials.getUser(), credentials.getPassword());
    }

    @AfterMethod
    public void clear(){
        //driver.close();

    }
}
