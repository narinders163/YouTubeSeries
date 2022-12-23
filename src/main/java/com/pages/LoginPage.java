package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	private WebDriver driver;
	public LoginPage(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name = 'username']")
	private WebElement username;
	
	@FindBy(css="input[name = 'password']")
	private WebElement password;
	
	@FindBy(css="button[type='submit']")
	private WebElement logInbutton;
	
	@FindBy(xpath="//p[text()='Invalid credentials']")
	private WebElement errorinlogin;
	
	@FindBy(xpath="//p[text()='Forgot your password? ']")
	private WebElement forgotpassword;
	
	public void enterusername(String user)
	{
		username.clear();
		username.sendKeys(user);
	}
	public void enterpassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	public void clicklogin()
	{
		logInbutton.click();
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
			b = errorinlogin.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
		
	}
	public String geterrortext()
	{
		String a = errorinlogin.getText();
		return a;
	}
	public void clickonforgotpassword()
	{
		forgotpassword.click();
	}

}
