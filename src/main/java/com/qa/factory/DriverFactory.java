package com.qa.factory;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> trdlocal = new ThreadLocal<>();
	
	
	public WebDriver init_dr(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.EAGER);
			trdlocal.set(new ChromeDriver());
		}
		else if (browser.equalsIgnoreCase("msedge"))
		{
			WebDriverManager.edgedriver().setup();
			trdlocal.set(new EdgeDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}

	public static synchronized WebDriver getDriver()
	{
		return trdlocal.get();
	}
}
