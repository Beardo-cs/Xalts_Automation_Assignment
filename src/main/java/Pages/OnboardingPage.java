package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OnboardingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By nodeIdInput = By.xpath("(//input[@id='outlined-basic'])[1]");
    private final By ipInput = By.xpath("(//input[@id='outlined-basic'])[2]");
    private final By addNodeButton = By.xpath("(//button[normalize-space()='+ Add Node'])[1]");
    private final By nextButton = By.xpath("//button[normalize-space()='Next']");
    private final By walletInput = By.xpath("(//input[@id='outlined-basic'])[1]");
    private final By addWalletButton = By.xpath("(//button[normalize-space()='+ Add Wallet'])[1]");
    private final By submitButton = By.xpath("//button[normalize-space()='Submit']");

    public OnboardingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterNodeId(String nodeId) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(nodeIdInput));
        element.clear();
        element.sendKeys(nodeId);
    }

    public void enterIpAddress(String ipAddress) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(ipInput));
        element.clear();
        element.sendKeys(ipAddress);
    }

    public void clickAddNodeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addNodeButton)).click();
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void enterWalletAddress(String walletAddress) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(walletInput));
        element.clear();
        element.sendKeys(walletAddress);
    }

    public void clickAddWalletButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addWalletButton)).click();
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
}