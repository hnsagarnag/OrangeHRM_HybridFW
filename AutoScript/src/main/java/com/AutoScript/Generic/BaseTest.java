package com.AutoScript.Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutoConstant
{
	public WebDriver driver;

	static
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(gecko_key, gecko_value);
	}
	@BeforeMethod
	public void preCondition() 
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.get("https://www.orangeHRM.com/");
	}
	
	@AfterMethod
	public void postCondition(ITestResult res)
	{
		int status = res.getStatus();
		if(status==2)
		{
			String name = res.getName();
			GenericUtils.getScreenShot(driver, name);
		}
		
		driver.close();
	}
}
