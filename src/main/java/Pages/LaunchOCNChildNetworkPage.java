package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LaunchOCNChildNetworkPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By networkNameInput = By.xpath("(//input[@id='outlined-basic'])[1]");
    private final By walletAddressInput = By.xpath("(//input[@id='outlined-basic'])[2]");
    private final By nextButton = By.xpath("//button[normalize-space()='Next']");
    private final By nodeIdInput = By.xpath("(//input[@id='outlined-basic'])[1]");
    private final By publicIpInput = By.xpath("(//input[@id='outlined-basic'])[2]");
    private final By addNodeButton = By.xpath("//button[normalize-space()='+ Add Node']");
    private final By submitButton = By.xpath("//button[normalize-space()='Submit']");

    public LaunchOCNChildNetworkPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterNetworkName(String networkName) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(networkNameInput));
        element.sendKeys(networkName);
    }

    public void enterWalletAddress(String walletAddress) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(walletAddressInput));
        element.sendKeys(walletAddress);
    }

    public void clickNextButton() {
        wait.until(ExpectedConditions.elementToBeClickable(nextButton)).click();
    }

    public void enterNodeId(String nodeId) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(nodeIdInput));
        element.sendKeys(nodeId);
    }

    public void enterPublicIp(String publicIp) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(publicIpInput));
        element.sendKeys(publicIp);
    }

    public void clickAddNodeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addNodeButton)).click();
    }

    public void clickSubmitButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }
}