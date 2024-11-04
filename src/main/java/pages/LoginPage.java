package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Helpers;

import java.time.Duration;

public class LoginPage {

    // WebDriver instance to interact with the browser
    private WebDriver driver;

    // Constructor initializes the driver for the current test session
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators for the username field, password field, and login button
    private By userField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

    //Performs login by waiting for elements to be visible, then entering credentials and clicking the login button
    public void login(String user, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Waits for the username field and inputs the username
        WebElement userElement = wait.until(ExpectedConditions.presenceOfElementLocated(userField));
        userElement.sendKeys(user);

        // Waits for the password field and inputs the password
        WebElement passElement = wait.until(ExpectedConditions.presenceOfElementLocated(passwordField));
        passElement.sendKeys(password);

        // Waits for the login button to be clickable and clicks to submit the form
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();

        WebElement dashboardHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module")));
        Assert.assertEquals(dashboardHeader.getText(), "Dashboard");

    }
}
