package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {
	
	private WebDriver driver;
	public ForgotPassword(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h6[text()='Reset Password']")
	private WebElement resettext;
	
	public boolean isresettextdisplayed()
	{
		boolean b = false;
		try
		{
			b = resettext.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

}
