package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.Credentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    // Constructor initializes the driver for the current test session
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By profileMenuField = By.className("oxd-userdropdown-name");
    private By changePassField = By.className("oxd-userdropdown-link");
    private By currentPassField = By.className("oxd-input oxd-input--active");
    private By newPassField = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input");
    private By confirmPassField = By.xpath("/html/body/div/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div[2]/input");
    private By savebuttonField = By.className("oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space");
    private By alertPassSavedField = By.xpath("//*[@id=\"oxd-toaster_1\"]");

    public void updatePass(String Current_password, String New_Password, String Confirm_Password){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Credentials credentials = new Credentials();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(credentials.getUser(), credentials.getPassword());

        WebElement profileMenuElement = wait.until(ExpectedConditions.elementToBeClickable(profileMenuField));
        profileMenuElement.click();

        WebElement changePassElement = wait.until(ExpectedConditions.elementToBeClickable(changePassField));
        changePassElement.click();

        WebElement currentPassElement = wait.until(ExpectedConditions.elementToBeClickable(currentPassField));
        currentPassElement.sendKeys(credentials.getPassword());

        WebElement newPassElement = wait.until(ExpectedConditions.elementToBeClickable(newPassField));
        newPassElement.sendKeys(credentials.getNewPassword());

        WebElement confirmPassElement = wait.until(ExpectedConditions.elementToBeClickable(confirmPassField));
        confirmPassElement.sendKeys(credentials.getNewPassword());

        WebElement savebuttonElement = wait.until(ExpectedConditions.elementToBeClickable(savebuttonField));
        savebuttonElement.click();





    }

}
