package com.AutoScript.Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.AutoScript.Generic.BaseTest;
import com.AutoScript.Generic.ExcelData;
import com.AutoScript.Page.EnterTimeTrackPage;
import com.AutoScript.Page.LoginPage;

public class ValidLoginLogoutTest extends BaseTest
{
	@Test(priority=1)
	public void testValidLoginLogout() throws InterruptedException
	{
		String username = ExcelData.getData(file_path, "TC01", 1, 0);
		String password = ExcelData.getData(file_path, "TC01", 1, 1);
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String enterTimeTrackTitle = ExcelData.getData(file_path, "TC01", 1, 3);
		
		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackPage ep = new EnterTimeTrackPage(driver);
		
		//verify login page
		lp.verifyPage(loginTitle);
		
		//Enter valid user name
		Reporter.log("Valid username: "+username,true);
		lp.enterUserName(username);
		
		//Enter valid password
		Reporter.log("Valid password: "+password,true);
		lp.enterPassword(password);
		
		//click on Login
		lp.clickOnLogin();
		Thread.sleep(2000);
		//verify enter time track page
		lp.verifyPage(enterTimeTrackTitle);
		
		//click on Logout
		ep.clickOnLogout();
		
		//verify login page
		lp.verifyPage(loginTitle);
	}
}
