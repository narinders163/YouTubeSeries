package com.qa.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElemUtils {
	public WebDriver dr;
	
	public  void scrollToElement(WebElement ele) throws InterruptedException
	{
		//JavascriptExecutor je = (JavascriptExecutor) dr;
		((JavascriptExecutor) dr).executeScript("arguments[0].scrollIntoView(false);", ele);
		Thread.sleep(2000);
		((JavascriptExecutor) dr).executeScript("window.scrollBy(0,200)", "");
	}
	public  void clickOnElement(WebElement ele) throws InterruptedException
	{
		//JavascriptExecutor je = (JavascriptExecutor) dr;
		((JavascriptExecutor) dr).executeScript("arguments[0].click();", ele);
	}
	public  String getDate()
	{
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.H.m.s.S");
		String ddaattee = sdf.format(dt);
		return ddaattee;
	}
	public void TakeScreenshot() throws IOException
	{
		TakesScreenshot tsc = (TakesScreenshot) dr;
		File src = tsc.getScreenshotAs(OutputType.FILE);
		String dd = getDate();
		FileHandler.copy(src, new File("./screenshots/"+dd+"image.jpg"));
		
	}
	public void AttachScreenshot() throws IOException
	{
		TakesScreenshot tsc = (TakesScreenshot) dr;
		byte[] src = tsc.getScreenshotAs(OutputType.BYTES);
		//String image = "<img src=\"data:image/png;base64,"+src+"\" height=\"600\" width=\"800\" />";
		//Reporter.log(image);
		
	}

	public void ElementWait(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(dr, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(ele));
		
	}

}
