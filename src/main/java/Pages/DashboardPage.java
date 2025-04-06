package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By signOutButton = By.xpath("//button[normalize-space()='Sign Out']");
    private final By getStartedButton = By.xpath("//button[normalize-space()='Get Started']");
    private final By onboardOCNNodeLink = By.xpath("//h2[normalize-space()='Onboard OCN Node']");
    private final By launchOCNChildNetworkLink = By.xpath("//h2[normalize-space()='Launch OCN Child Network']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickSignOutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signOutButton)).click();
    }

    public void clickGetStarted() {
        wait.until(ExpectedConditions.elementToBeClickable(getStartedButton)).click();
    }

    public void navigateToOnboardNode() {
        wait.until(ExpectedConditions.elementToBeClickable(onboardOCNNodeLink)).click();
    }

    public void navigateToLaunchChildNetwork() {
        wait.until(ExpectedConditions.elementToBeClickable(launchOCNChildNetworkLink)).click();
    }
}