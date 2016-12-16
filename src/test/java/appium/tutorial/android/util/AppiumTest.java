package appium.tutorial.android.util;

import appium.tutorial.android.page.HomePage;

import com.saucelabs.common.SauceOnDemandAuthentication;
import com.saucelabs.common.SauceOnDemandSessionIdProvider;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import com.saucelabs.saucerest.SauceREST;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.logging.LogFactory;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static appium.tutorial.android.util.Helpers.back;
import static appium.tutorial.android.util.Helpers.driver;


public class AppiumTest implements SauceOnDemandSessionIdProvider {

    static {
        // Disable annoying cookie warnings.
        // WARNING: Invalid cookie header
        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
    }

    /**
     * Page object references. Allows using 'home' instead of 'HomePage'
     **/
    protected HomePage home;

    /**
     * wait wraps Helpers.wait
     **/
    public static WebElement wait(By locator) {
        return Helpers.wait(locator);
    }

    private boolean runOnSauce = System.getProperty("sauce") != null;

    /**
     * Authenticate to Sauce with environment variables SAUCE_USER_NAME and SAUCE_API_KEY
     **/
    private SauceOnDemandAuthentication auth = new SauceOnDemandAuthentication();

    /**
     * Report pass/fail to Sauce Labs
     **/
    // false to silence Sauce connect messages.
    public
    @Rule
    SauceOnDemandTestWatcher reportToSauce = new SauceOnDemandTestWatcher(this, auth, false);

    @Rule
    public TestRule printTests = new TestWatcher() {
        protected void starting(Description description) {
            System.out.print("  test: " + description.getMethodName());
        }

        protected void finished(Description description) {
            final String session = getSessionId();

            if (session != null) {
                System.out.println(" " + "https://saucelabs.com/tests/" + session);
            } else {
                System.out.println();
            }
        }
    };

    private String sessionId;

    /**
     * Keep the same date prefix to identify job sets.
     **/
    private static Date date = new Date();

    /**
     * Run before each test
     **/
    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.1.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android");
        capabilities.setCapability("platformVersion", "4.3");

        //Android 6 permission
        capabilities.setCapability("locationServicesAuthorized", true);
        capabilities.setCapability("autoAcceptAlerts", true);

        // Set job name on Sauce Labs
        capabilities.setCapability("name", "Java Android tutorial " + date);
        String userDir = System.getProperty("user.dir");

        URL serverAddress;
        String localApp = "qabify.apk";
        if (runOnSauce) {
            String user = auth.getUsername();
            String key = auth.getAccessKey();

            // Upload app to Sauce Labs
            SauceREST rest = new SauceREST(user, key);

            rest.uploadFile(new File(userDir, localApp), localApp);

            capabilities.setCapability("app", "sauce-storage:" + localApp);
            serverAddress = new URL("http://" + user + ":" + key + "@ondemand.saucelabs.com:80/wd/hub");
            driver = new AndroidDriver(serverAddress, capabilities);
        } else {
            String appPath = Paths.get(userDir, localApp).toAbsolutePath().toString();
            capabilities.setCapability("app", appPath);
            serverAddress = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(serverAddress, capabilities);
        }


        sessionId = driver.getSessionId().toString();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        Helpers.init(driver, serverAddress);

    }

    /**
     * Run after each test
     **/
    @After
    public void tearDown() throws Exception {
        if (driver != null) driver.quit();
    }

    /**
     * If we're not on Sauce then return null otherwise SauceOnDemandTestWatcher will error.
     **/
    public String getSessionId() {
        return runOnSauce ? sessionId : null;
    }

    String mailButtonId = "com.cabify.qabify:id/email";
    String passwordButtonId = "com.cabify.qabify:id/password";
    String loginButtonId = "com.cabify.qabify:id/email_sign_in_button";
    String showPasswordId = "com.cabify.qabify:id/text_input_password_toggle";
    String tokenButtonId = "com.cabify.qabify:id/token_button";
    String userLoggedId = "com.cabify.qabify:id/textView";
    String userOnePassword = "password";
    String userOneEmail = "user1@example.com";
    String adminPassword = "nmT8bSVJepgWrryx";
    String adminEmail = "admin@example.com";

    @Given("User is on Signup screen")
    public void check_Signup_Screen() throws Exception {

        driver.findElement(By.name("SIGN IN OR REGISTER"));

    }

    @When("User enter user1 details")
    public void add_UserOne_Info() throws Exception {

        driver.findElementById(mailButtonId).sendKeys(userOneEmail);
        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);

    }

    @When("User enter admin details")
    public void add_Admin_Info() throws Exception {

        driver.findElementById(mailButtonId).sendKeys(adminEmail);
        driver.findElementById(passwordButtonId).sendKeys(adminPassword);

    }

    @When("User login")
    public void login_Action() throws Exception {
        driver.findElementById(loginButtonId).click();

    }

    @Then("Login user1 successfull")
    public void login_UserOne_Sucess() throws Exception {
        driver.findElementById(userLoggedId).getText().equals("Hi, User1");

    }

    @Then("Login admin successfull")
    public void login_Admin_Sucess() throws Exception {
        driver.findElementById(userLoggedId).getText().equals("Hi, Admin");

    }

    @When("User enter invalid email")
    public void enter_Invalid_Email() throws Exception {

        driver.findElementById(mailButtonId).sendKeys("user1example.com");
        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
    }

    @Then("Login validation error")
    public void invalid_Email_Check() throws Exception {
        if (driver.findElementById(tokenButtonId).isDisplayed()) {
            throw new Exception("Oops! Impossible login .");
        }
    }

    @When("User enter password")
    public void empty_Email() throws Exception {

        driver.findElementById(passwordButtonId).sendKeys(userOnePassword);
    }

    @When("User enter user1 email")
    public void enter_UserOne_Email() throws Exception {

        driver.findElementById(mailButtonId).sendKeys(userOneEmail);
    }

    @When("User show password")
    public void show_Password() throws Exception {

        driver.findElementById(showPasswordId).click();
    }

    @Then("The password is displayed")
    public void check_Displayed_Password() throws Exception {

        driver.findElement(By.name(userOnePassword));
    }

    @When("User enter short password")
    public void enter_Too_Short_Password() throws Exception {

        driver.findElementById(passwordButtonId).sendKeys("11=");
    }

    @Given("User1 logged")
    public void user_Logged() throws Exception {
        add_UserOne_Info();
        login_Action();

    }

    @Given("Admin logged")
    public void admin_Logged() throws Exception {
        add_Admin_Info();
        login_Action();

    }

    @When("User show token")
    public void user_Show_Token() throws Exception {
        driver.findElementById(tokenButtonId).click();

    }

    @Then("Admin token its the same")
    public void compare_Token_Admin() throws Exception {
        driver.findElement(By.name("123456789"));

    }

    @Then("User1 token its the same")
    public void compare_Token_UserOne() throws Exception {
        driver.findElement(By.name("abcdefghi"));

    }
}