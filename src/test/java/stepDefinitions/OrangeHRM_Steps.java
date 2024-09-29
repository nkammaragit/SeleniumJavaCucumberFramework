package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.pageObjects.LoginPage;
import com.utils.SeleniumUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testRunner.TestRunner;

public class OrangeHRM_Steps {
    WebDriver driver;
    WebDriverWait wait;
    Properties prop;
    LoginPage loginPage;
    SeleniumUtils selUtils;

    @Given("Launch Chrome browser")
    public void launch_chrome_browser() throws IOException {
        TestRunner.test.info("Launching Chrome browser");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Initialize page objects
        loginPage = new LoginPage(driver);
        selUtils = new SeleniumUtils();

        // Load properties file
        prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
        prop.load(fis);
        TestRunner.test.pass("Chrome browser launched successfully");
    }

    @When("Open Orange HRM login page")
    public void open_orange_hrm_login_page() {
        TestRunner.test.info("Opening Orange HRM login page");
        driver.get(prop.getProperty("url"));
        TestRunner.test.pass("Orange HRM login page opened successfully");
    }

    @Then("Verify that the logo is present on page")
    public void verify_that_the_logo_is_present_on_page() throws InterruptedException {
        TestRunner.test.info("Verifying that the logo is present on the page");
        try {
            Thread.sleep(10000);
            WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='orangehrm-login-logo']//img[@src='/web/images/ohrm_logo.png' and @alt='orangehrm-logo']")));
            boolean status = logo.isDisplayed();
            Assert.assertTrue(status, "Logo is not displayed");
            TestRunner.test.pass("Logo is displayed on the login page");
        } catch (AssertionError e) {
            TestRunner.test.fail("Logo verification failed: " + e.getMessage());
            throw e;
        }
    }

    @When("Enter valid username and password")
    public void enter_valid_username_and_password() throws InterruptedException {
        TestRunner.test.info("Entering valid username and password");
        try {
            Thread.sleep(10000);
            loginPage.enterUsername(prop.getProperty("username"));
            loginPage.enterPassword(prop.getProperty("password"));
            Thread.sleep(10000);
            loginPage.clickLogin();
            TestRunner.test.pass("Username and password entered successfully");
        } catch (Exception e) {
            TestRunner.test.fail("Failed to enter username and password: " + e.getMessage());
            throw e;
        }
    }

    @Then("Login success")
    public void login_success() throws InterruptedException {
        TestRunner.test.info("Verifying login success");
        Thread.sleep(10000);
        try {
            WebElement lnkDashboard = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Dashboard']")));
            Assert.assertTrue(lnkDashboard.isDisplayed(), "Dashboard is not displayed");
            TestRunner.test.pass("Login successful, Dashboard is displayed");
        } catch (Exception e) {
            SeleniumUtils.captureScreenshot(driver, "LoginFailed");
            TestRunner.test.fail("Login failed: " + e.getMessage());
            Assert.fail("Login Failed");
        }
    }

    @And("Close the browser")
    public void close_the_browser() {
        TestRunner.test.info("Closing the browser");
        driver.quit();
        TestRunner.test.pass("Browser closed successfully");
    }

    @When("Enter username {string} and password {string}")
    public void enter_username_and_password(String username, String password) throws InterruptedException {
        TestRunner.test.info("Entering username: " + username + " and password");
        try {
            Thread.sleep(10000);
            loginPage.enterUsername(username);
            loginPage.enterPassword(password);
            Thread.sleep(10000);
            loginPage.clickLogin();
            TestRunner.test.pass("Entered username: " + username + " and password successfully");
        } catch (Exception e) {
            TestRunner.test.fail("Failed to enter username and password: " + e.getMessage());
            throw e;
        }
    }
}
