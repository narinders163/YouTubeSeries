package com.qa.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverFactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> trdlocal = new ThreadLocal<>();


	public WebDriver init_dr(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			trdlocal.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			trdlocal.set(new EdgeDriver());
		}
		else
		{
			System.out.println("No browser found");
		}
		getdriver().manage().deleteAllCookies();
		getdriver().manage().window().maximize();

		return getdriver();
	}
	public static synchronized WebDriver getdriver()
	{
		return trdlocal.get();
	}

}
