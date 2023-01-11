package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage{
	
	private WebDriver driver;
	public LoginPage(WebDriver dr)
	{
		this.driver=dr;
	}

	private By username = By.cssSelector("input[name = 'username']");

	private By password = By.cssSelector("input[name = 'password']");

	private By logInbutton = By.cssSelector("button[type='submit']");

	private By errorinlogin = By.xpath("//p[text()='Invalid credentials']");

	private By forgotpassword = By.xpath("//p[text()='Forgot your password? ']");
	
	public void enterusername(String user)
	{
		driver.findElement(username).clear();
		driver.findElement(username).sendKeys(user);
	}
	public void enterpassword(String pass)
	{
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(pass);
	}
	public DashBoard clicklogin()
	{
		driver.findElement(logInbutton).click();
		return new DashBoard(driver);
	}
	public DashBoard LoginToApp(String user , String pass)
	{
		enterusername(user);
		enterpassword(pass);
		clicklogin();
		return new DashBoard(driver);
	}
	public boolean iserrorlogindisplayed()
	{
		boolean b = false;
		try
		{
			b = driver.findElement(errorinlogin).isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
		
	}
	public String geterrortext()
	{
		String a = driver.findElement(errorinlogin).getText();
		return a;
	}
	public ForgotPassword clickonforgotpassword()
	{
		driver.findElement(forgotpassword).click();
		return new ForgotPassword(driver);
	}

}
