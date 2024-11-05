package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helpers {

    // URL for the web application
    private String urlWeb = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    // Helper method to wait for an element and input text
    public void waitForElementAndInput(By locator, String text, WebDriverWait wait) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        element.clear();  // Clear the input field before entering text
        element.sendKeys(text); // Input the provided text
    }

    // Getter for the web application URL
    public String getUrlWeb() {
        return urlWeb;
    }
}
