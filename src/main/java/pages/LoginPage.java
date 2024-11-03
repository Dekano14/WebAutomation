package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Helpers;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;
    private Credentials credentials;
    private Helpers helpers;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

    public void login(String user, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement userElement = wait.until(ExpectedConditions.presenceOfElementLocated(userField));
        userElement.sendKeys(user);
        //
        WebElement passElement = wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        passElement.sendKeys(password);

        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();

    }
}