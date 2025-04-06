package StepDefinition;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import Pages.*;
import util.WebDriverFactory;

public class SignupSigninSteps {
    private WebDriver driver;
    private HomePage homePage;
    private SignupPage signupPage;
    private SigninPage signinPage;
    private DashboardPage dashboardPage;
    private OnboardingPage onboardingPage;
    private LaunchOCNChildNetworkPage launchOCNChildNetworkPage;

    private static String generatedEmail;
    private static String generatedPassword;
    private static String firstName;
    private static String lastName;
    private WebDriverWait wait;

    private String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }
        return sb.toString();
    }

    private String generateNumericPassword() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder("Test@");
        for (int i = 0; i < 6; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    private String shuffleString(String input) {
        List<Character> characters = new ArrayList<>();
        for (char c : input.toCharArray()) {
            characters.add(c);
        }
        Collections.shuffle(characters);
        StringBuilder output = new StringBuilder();
        for (char c : characters) {
            output.append(c);
        }
        return output.toString();
    }

    @Given("I launch the browser and navigate to Xalts home page")
    public void launch_browser_and_navigate() {
        driver = WebDriverFactory.createDriver();

        // Initialize page objects
        homePage = new HomePage(driver);
        signupPage = new SignupPage(driver);
        signinPage = new SigninPage(driver);
        dashboardPage = new DashboardPage(driver);
        onboardingPage = new OnboardingPage(driver);
        launchOCNChildNetworkPage = new LaunchOCNChildNetworkPage(driver);

        homePage.navigateToHomePage();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I click on Get Started")
    public void click_on_GetStarted_Button() {
        homePage.clickGetStarted();
    }

    @When("I enter email address")
    public void enter_email_address() {
        if (firstName == null || lastName == null) {
            firstName = generateRandomString(6);
            lastName = generateRandomString(6);
        }
        generatedEmail = firstName + lastName + "@example.com";
        signupPage.enterEmail(generatedEmail);
    }

    @When("I enter password and confirm password")
    public void enter_password() {
        generatedPassword = generateNumericPassword();
        signupPage.enterPassword(generatedPassword);
        signupPage.enterConfirmPassword(generatedPassword);
    }

    @When("I click on Sign up button")
    public void click_create_account_button() {
        signupPage.clickSignUpButton();
    }

    @Then("I click on Sign out button")
    public void Sign_out_from_created_account() {
        dashboardPage.clickSignOutButton();
    }

    @When("I click on Sign In link")
    public void click_sign_in() {
        signupPage.clickSignInLink();
    }

    @When("I enter the generated email and password")
    public void enter_generated_credentials() {
        signinPage.enterEmail(generatedEmail);
        signinPage.enterPassword(generatedPassword);
    }

    @When("I click on Sign In button")
    public void click_sign_in_button() {
        signinPage.clickSignInButton();
    }

    // === STEPS FOR ONBOARDING FEATURE ===

    @Then("Click on Get Started")
    public void clickOnGetStarted() {
        dashboardPage.clickGetStarted();
    }

    @Then("Navigate to Onboard Node page")
    public void navigateToOnboardNodePage() {
        dashboardPage.navigateToOnboardNode();
    }

    @Then("Add node with ID {string} and IP {string}")
    public void addNodeWithIdAndIp(String nodeId, String ipAddress) {
        onboardingPage.enterNodeId(nodeId);
        onboardingPage.enterIpAddress(ipAddress);
        onboardingPage.clickAddNodeButton();
    }

    @Then("Click Next after adding nodes")
    public void clickNextAfterNodes() {
        onboardingPage.clickNextButton();
    }

    @Then("Add wallet address {string}")
    public void addWalletAddress(String walletAddress) {
        onboardingPage.enterWalletAddress(walletAddress);
        onboardingPage.clickAddWalletButton();
    }

    @Then("Click Next after adding wallets")
    public void clickNextAfterWallets() {
        onboardingPage.clickNextButton();
    }

    @Then("Submit the onboarding request")
    public void submitOnboardingRequest() {
        onboardingPage.clickSubmitButton();
    }

    @Then("Click Launch OCN Child Network")
    public void clickLaunchOCNChildNetwork() {
        dashboardPage.navigateToLaunchChildNetwork();
    }

    @Then("Enter the Network Name as {string}")
    public void enterNetworkName(String networkName) {
        launchOCNChildNetworkPage.enterNetworkName(networkName);
    }

    @Then("Enter the Wallet address as {string}")
    public void enterWalletAddress(String walletAddress) {
        launchOCNChildNetworkPage.enterWalletAddress(walletAddress);
    }

    @Then("Click the Next button")
    public void clickNextButton() {
        launchOCNChildNetworkPage.clickNextButton();
    }

    @Then("Enter Node ID as {string}")
    public void enterNodeID(String nodeId) {
        launchOCNChildNetworkPage.enterNodeId(nodeId);
    }

    @Then("Enter Public IP as {string}")
    public void enterPublicIP(String publicIp) {
        launchOCNChildNetworkPage.enterPublicIp(publicIp);
    }

    @Then("Click Add Node button")
    public void clickAddNode() {
        launchOCNChildNetworkPage.clickAddNodeButton();
    }

    @Then("Click the final Next button")
    public void clickFinalNextButton() {
        launchOCNChildNetworkPage.clickNextButton();
    }

    @Then("Click the Submit button to create Blockchain")
    public void clickSubmitButton() {
        launchOCNChildNetworkPage.clickSubmitButton();
    }


    @After
    public void tearDown(Scenario scenario) {
        try {
            String screenshotName = scenario.getName();
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) driver;
                byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "img/png", screenshotName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }
}