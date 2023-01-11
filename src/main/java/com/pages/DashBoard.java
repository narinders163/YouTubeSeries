package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashBoard {
	
    private WebDriver driver;
	public DashBoard(WebDriver dr)
	{
		this.driver=dr;
	}

	private By dropdown = By.cssSelector("p.oxd-userdropdown-name");

	private By logout = By.xpath("//a[text()='Logout']");
	private By MyInfo = By.xpath("//span[text()='My Info']");

	private By dashboardelement = By.xpath("//h6[text()='Dashboard']");

	/*private By AssignLeave = By.xpath("//div[@title='Assign Leave']");
	private By LeaveList = By.xpath("//div[@title='Leave List']");
	private By Timesheets = By.xpath("//div[@title='Timesheets']");
	private By ApplyLeave = By.xpath("//div[@title='Apply Leave']");
	private By MyLeave = By.xpath("//div[@title='My Leave']");
	private By MyTimesheet = By.xpath("//div[@title='My Timesheet']");

	private List<WebElement> list = new ArrayList<WebElement>();


	public List<WebElement> QuickLaungeElements()
	{
		list.add(driver.findElement(AssignLeave));
		list.add(driver.findElement(LeaveList));
		list.add(driver.findElement(Timesheets));
		list.add(driver.findElement(ApplyLeave));
		list.add(driver.findElement(MyLeave));
		list.add(driver.findElement(MyTimesheet));
		return list;


	}




	public List<String> GetElementsNames() {
		List<String> nameslist = new ArrayList<String>();
		for(WebElement ele : QuickLaungeElements())
		{
			nameslist.add(ele.getText().trim());
		}
		return nameslist;

	}*/

	public void clickOnMyInfo()
	{
		driver.findElement(MyInfo).click();

	}

	private By QuickLaunge = By.cssSelector("div.orangehrm-quick-launch-heading");

	public int getQuickLaungeCount()
	{
		return driver.findElements(QuickLaunge).size();
	}

	public List<String> getQuickLaungeItemsNames()
	{
		List<WebElement> list = driver.findElements(QuickLaunge);
		List<String> names = new ArrayList<String>();
		for(WebElement ele:list)
		{
			names.add(ele.getText().trim());
		}
		return names;
	}

	public void loggingout() throws InterruptedException
	{
		driver.findElement(dropdown).click();
		Thread.sleep(1000);
		driver.findElement(logout).click();
	}
	
	public boolean isdashdisplayed()
	{
		boolean b = false;
		try
		{
			b = driver.findElement(dashboardelement).isDisplayed();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
		
	}

	
	
	
	
	
}
