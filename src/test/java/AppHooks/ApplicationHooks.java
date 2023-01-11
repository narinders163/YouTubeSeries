package AppHooks;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Properties;

public class ApplicationHooks {
	
	private WebDriver dr;
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	public Properties prop;
	
	@Before(order = 1)
	public void getProperty() throws IOException
	{
		configReader = new ConfigReader();
		prop = configReader.getProperty();
		
	}
	@Before(order = 2)
	public void getBrowser() throws IOException
	{
		String browsername = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		dr = driverFactory.init_dr(browsername);
	}
	
	@After(order=1)
	public void quitBrowser()
	{
		dr.close();
	}
	@After(order=2)
	public void screenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			TakesScreenshot takesScreenshot = ((TakesScreenshot)dr);
			byte[] b = takesScreenshot.getScreenshotAs(OutputType.BYTES);
			String name = scenario.getName().replace(" ", "_");
			scenario.attach(b , "image/png" , "name");
		}
	}

	

}
