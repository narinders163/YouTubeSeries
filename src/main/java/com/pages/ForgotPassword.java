package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {
	
	private WebDriver driver;
	public ForgotPassword(WebDriver dr)
	{
		this.driver=dr;
	}

	private By resettext = By.xpath("//h6[text()='Reset Password']");
	
	public boolean isresettextdisplayed()
	{
		boolean b = false;
		try
		{
			b = driver.findElement(resettext).isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}

}
