package appium.tutorial.android;

import appium.tutorial.android.util.AppiumTest;
import cucumber.api.CucumberOptions;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

import static appium.tutorial.android.util.Helpers.*;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;


public class AutomatingLoginTest /*extends AppiumTest*/ {

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

	/*@Given("User is on Signup screen")
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

	}*/

}