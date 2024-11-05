package testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Credentials;
import utils.Helpers;
import java.time.Duration;

public class LoginTest {

    private ChromeDriver driver;
    private Credentials credentials;
    private LoginPage loginPage;  // Moved loginPage initialization here to reduce redundancy
    private WebDriverWait wait;   // Moved WebDriverWait initialization here for reuse

    @BeforeMethod
    public void setUp(){
        // Set up ChromeDriver path and initialize the driver
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        // Initialize Credentials and Helpers
        credentials = new Credentials();
        Helpers helpers = new Helpers();

        // Navigate to the URL and maximize the window
        driver.get(helpers.getUrlWeb());
        driver.manage().window().maximize();

        // Initialize WebDriverWait for use in tests
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Initialize LoginPage for use in tests
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginFail(){
        // Attempt to log in with invalid credentials
        loginPage.login(credentials.getUserfail(), credentials.getPassfail());

        // Wait for the invalid alert and assert its message
        WebElement alertInvalidElement = wait.until(ExpectedConditions.elementToBeClickable(loginPage.getAlertInvalidField()));
        Assert.assertEquals(alertInvalidElement.getText(), loginPage.LABEL_INVALID_CREDENTIALS);
    }

    @Test
    public void loginSuccess(){
        // Attempt to log in with valid credentials
        loginPage.login(credentials.getUser(), credentials.getPassword());

        // Wait for the dashboard header and assert its text
        WebElement dashboardElement = wait.until(ExpectedConditions.elementToBeClickable(loginPage.getDashboardHeader()));
        Assert.assertEquals(dashboardElement.getText(), loginPage.LABEL_DASHBOARD);
    }

    @AfterMethod
    public void clear(){
        // Close the browser after each test
        driver.close();
    }
}
