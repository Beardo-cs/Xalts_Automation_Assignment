package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.time.Duration;

public class WebDriverFactory {

    private static final String BROWSER_PROPERTY = "browser";
    private static final String HEADED_PROPERTY = "headed";
    private static final String DEFAULT_BROWSER = "chrome";

    public static WebDriver createDriver() {
        String browserType = System.getProperty(BROWSER_PROPERTY, DEFAULT_BROWSER).toLowerCase();
        boolean headedMode = Boolean.parseBoolean(System.getProperty(HEADED_PROPERTY, "false"));

        WebDriver driver;
        switch (browserType) {
            case "firefox":
                driver = createFirefoxDriver(headedMode);
                break;
            case "edge":
                driver = createEdgeDriver(headedMode);
                break;
            case "chrome":
            default:
                driver = createChromeDriver(headedMode);
                break;
        }

        configureDriver(driver);
        return driver;
    }

    private static WebDriver createChromeDriver(boolean headedMode) {
        ChromeOptions options = new ChromeOptions();
        if (!headedMode) {
            options.addArguments("--headless");
        }
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean headedMode) {
        FirefoxOptions options = new FirefoxOptions();
        if (!headedMode) {
            options.addArguments("--headless");
        }
        return new FirefoxDriver(options);
    }

    private static WebDriver createEdgeDriver(boolean headedMode) {
        EdgeOptions options = new EdgeOptions();
        if (!headedMode) {
            options.addArguments("--headless");
        }
        return new EdgeDriver(options);
    }

    private static void configureDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    }
}