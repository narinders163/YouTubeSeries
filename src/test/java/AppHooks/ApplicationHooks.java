package AppHooks;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

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
		dr.quit();
	}
	

}
