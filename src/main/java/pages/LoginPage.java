package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.Helpers;

public class LoginPage {

    // WebDriver instance to interact with the browser
    private WebDriver driver;
    private Helpers helpers; // Instance of Helpers to use the wait method

    // Constructor initializes the driver and helpers for the current test session
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.helpers = new Helpers(); // Initialize the Helpers instance
    }

    // Labels for validation messages
    public static final String LABEL_DASHBOARD = "Dashboard"; // Dashboard label
    public static final String LABEL_INVALID_CREDENTIALS = "Invalid credentials"; // Invalid credentials label

    // Locators for the username field, password field, login button, dashboard header, and alert
    private By userField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");
    private By dashboardHeader = By.cssSelector("h6.oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    private By alertInvalidField = By.cssSelector(".oxd-alert");

    // Getters for locators
    public By getDashboardHeader() {
        return dashboardHeader;
    }

    public By getAlertInvalidField() {
        return alertInvalidField;
    }

    // Performs login by waiting for elements to be visible, entering credentials, and clicking the login button
    public void login(String user, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Waits for the username field and inputs the username
        helpers.waitForElementAndInput(userField, user, wait);

        // Waits for the password field and inputs the password
        helpers.waitForElementAndInput(passwordField, password, wait);

        // Waits for the login button to be clickable and clicks to submit the form
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }
}
