package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SigninPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By emailField = By.xpath("(//input[@id='outlined-basic'])[1]");
    private final By passwordField = By.xpath("(//input[@id='outlined-basic'])[2]");
    private final By signInButton = By.xpath("//button[normalize-space()='Sign In']");

    public SigninPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickSignInButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
    }
}