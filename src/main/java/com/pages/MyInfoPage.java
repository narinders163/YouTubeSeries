package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MyInfoPage{
	private WebDriver driver;
	public MyInfoPage(WebDriver dr)
	{
		this.driver=dr;
	}

	private By SideMenuItems = By.cssSelector("div.orangehrm-tabs-wrapper");

	public int getSideMenuItemsCount()
	{
		return driver.findElements(SideMenuItems).size();
	}


	public List<String> getSideMenuItemsNames()
	{
		List<WebElement> list = driver.findElements(SideMenuItems);
		List<String> names = new ArrayList<String>();
		for(WebElement ele:list)
		{
			names.add(ele.getText().trim());
		}
		return names;
	}


}
