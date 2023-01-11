package stepdefinition;

import com.pages.DashBoard;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.utils.ElemUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginTestDefinition {

	private LoginPage lp = new LoginPage(DriverFactory.getdriver());
	private DashBoard dash = new DashBoard(DriverFactory.getdriver());
	private ElemUtils elemUtils = new ElemUtils();
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() throws InterruptedException {
		DriverFactory.getdriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(3000);
		System.out.println("Opened browser and URL");
	}

	@When("user enters the {string} and {string}")
	public void user_enters_the_and(String string, String string2) {
	 lp.enterusername(string);
	 lp.enterpassword(string2);
	 System.out.println("Entered username and password");
	}

	@When("user clicks on the Submit button")
	public void user_clicks_on_the_submit_button() throws InterruptedException {
		lp.clicklogin();
		Thread.sleep(3000);
		System.out.println("Clicking on the submit button");
	   
	}

	@Then("user should be able to login")
	public void user_should_be_able_to_login() {
		Assert.assertTrue(dash.isdashdisplayed());
	}

	@Then("user should not be able to login")
	public void user_should_not_be_able_to_login() {
		Assert.assertFalse(dash.isdashdisplayed());
	}



}
