package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyInfoPage {
	private WebDriver driver;
	public MyInfoPage(WebDriver dr)
	{
		this.driver=dr;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='My Info']")
	private WebElement MyInfo;
	
	public void clickOnMyInfo()
	{
		MyInfo.click();
	}
	
	@FindBy(css="div.orangehrm-tabs-wrapper")
	private List<WebElement> SideMenuItems;
	
	public List<String> SideMenuItemsNames()
	{
		List<String> tmp = new ArrayList<String>();
		for(WebElement ele:SideMenuItems)
		{
			tmp.add(ele.getText().trim());
		}
		return tmp;
	}
	public int SideMenuItemsCount()
	{
		return SideMenuItems.size();
	}

}
