package stepdefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;

import com.pages.DashBoard;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginTestDefinition {
	private WebDriver driver = DriverFactory.getDriver();
	//DriverFactory d = new DriverFactory();
	
	
	
	private LoginPage lp = new LoginPage(driver);
	private DashBoard dash;
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() throws InterruptedException {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		System.out.println("Already Done");
	}

	@When("user enters the {string} and {string}")
	public void user_enters_the_and(String string, String string2) {
		
	 dash = lp.LoginToApp(string, string2);
	 System.out.println("Already Done");
	}

	@When("user clicks on the Submit button")
	public void user_clicks_on_the_submit_button() {
	   System.out.println("Already Done");
	   
	}

	@Then("user should be able to login")
	public void user_should_be_able_to_login() {
	 //assertTrue(dash.isdashdisplayed());
	}


}
