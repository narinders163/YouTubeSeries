package stepdefinition;

import com.pages.DashBoard;
import com.pages.LoginPage;
import com.pages.MyInfoPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class MyInfoDefinition {
    private LoginPage lp = new LoginPage(DriverFactory.getdriver());
    private DashBoard dash = new DashBoard(DriverFactory.getdriver());
    private MyInfoPage myi = new MyInfoPage(DriverFactory.getdriver());


    @When("user clicks on MyInfo Button")
    public void user_clicks_on_my_info_button() throws InterruptedException {
        Thread.sleep(3000);
        dash.clickOnMyInfo();

    }

    @Then("user should see exact number of  buttons")
    public void user_should_see_buttons() throws InterruptedException {
        Thread.sleep(3000);
        int act = myi.getSideMenuItemsCount();
        System.out.println(act);
        int exp = 11;
        Assert.assertEquals(exp , act);

    }

    @Then("user should see the exact names of the elements")
    public void user_should_see_the_exact_names_of_the_elements() throws InterruptedException {
        List<String> exp = new ArrayList<String>();
        List<String> act = myi.getSideMenuItemsNames();

        exp.add("Personal Details");
        exp.add("Contact Details");
        exp.add("Emergenct Contacts");
        exp.add("Dependents");
        exp.add("Immigration");
        exp.add("Jobs");
        exp.add("Salary");
        exp.add("Tax Exemptions");
        exp.add("Report-to");
        exp.add("Qualifications");
        exp.add("Memberships");

        Thread.sleep(4000);
        System.out.println(act);
        //Assert.assertEquals(exp , act);




    }
}
