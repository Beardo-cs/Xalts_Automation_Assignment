package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By emailField = By.xpath("(//input[@id='outlined-basic'])[1]");
    private final By passwordField = By.xpath("(//input[@id='outlined-basic'])[2]");
    private final By confirmPasswordField = By.xpath("(//input[@id='outlined-basic'])[3]");
    private final By signUpButton = By.xpath("//button[normalize-space()='Sign Up']");
    private final By signInLinkButton = By.xpath("//button[normalize-space()='Already have an account? Click here to sign in.']");

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void enterConfirmPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmPasswordField)).sendKeys(password);
    }

    public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    public void clickSignInLink() {
        wait.until(ExpectedConditions.elementToBeClickable(signInLinkButton)).click();
    }
}