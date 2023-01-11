package stepdefinition;

import com.pages.DashBoard;
import com.pages.ForgotPassword;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class DashBoardDefinition {

    private LoginPage lp = new LoginPage(DriverFactory.getdriver());
    private DashBoard dash = new DashBoard(DriverFactory.getdriver());
    private ForgotPassword fp = new ForgotPassword(DriverFactory.getdriver());

    @Given("dashboard page is visible")
    public void dashboard_page_is_visible() {
        Assert.assertTrue(dash.isdashdisplayed());
    }
    @Then("verify the QuickLaunge items count")
    public void verify_the_quick_launge_items_count() throws InterruptedException {
        Thread.sleep(3000);
        int exp = 6;
        System.out.println(dash.getQuickLaungeCount());
        Assert.assertEquals(exp , dash.getQuickLaungeCount());

    }
    @Then("verify the QuickLanuge items names")
    public void verify_the_quick_lanuge_items_names() throws InterruptedException {

        List<String> act = dash.getQuickLaungeItemsNames();
        List<String> exp = new ArrayList<String>();
        exp.add("Assign Leave");
        exp.add("Leave List");
        exp.add("Timesheets");
        exp.add("Apply Leave");
        exp.add("My Leave");
        exp.add("My Timesheet");
        //Assert.assertArrayEquals(names , dash.QuickLaungeNames());
        Thread.sleep(4000);
        System.out.println(dash.getQuickLaungeItemsNames());
        Assert.assertEquals(exp , act);





    }

}
