package stepdefinition;

import com.pages.DashBoard;
import com.pages.ForgotPassword;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ForgotPasswordDefinition {

    private LoginPage lp = new LoginPage(DriverFactory.getdriver());
    private DashBoard dash;// = new DashBoard(DriverFactory.getdriver());
    private ForgotPassword fp;// = new ForgotPassword(DriverFactory.getdriver());


    @When("the user clicks on the forgot password button")
    public void the_user_clicks_on_the_forgot_password_button() throws InterruptedException {
    fp = lp.clickonforgotpassword();
    Thread.sleep(3000);
    }
    @Then("the user should see the forgotpassword page")
    public void the_user_should_see_the_forgotpassword_page() {
        Assert.assertTrue(fp.isresettextdisplayed());

    }

}