package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoard {
	
    private WebDriver driver;
	public DashBoard(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="p.oxd-userdropdown-name")
	private WebElement dropdown;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	private WebElement dashboardelement;
	
	@FindBy(xpath="//div[@class='orangehrm-quick-launch-heading']")
	private List<WebElement> QuickLaunge = new ArrayList<WebElement>();
	
	public List<String> QuickLaungeNames()
	{
		List<String> tmp = new ArrayList<String>();
		for(WebElement ele:QuickLaunge)
		{
			tmp.add(ele.getText().trim());
		}
		return tmp;
	}
	
	public int itemscount()
	{
		int i = QuickLaunge.size();
		return i;
	}
	
	public void loggingout() throws InterruptedException
	{
		dropdown.click();
		Thread.sleep(1000);
		logout.click();
	}
	
	public boolean isdashdisplayed()
	{
		boolean b = false;
		try
		{
			b = dashboardelement.isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
		
	}
	
	
	
	
	
}
