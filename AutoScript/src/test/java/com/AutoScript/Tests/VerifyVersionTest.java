package com.AutoScript.Tests;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.AutoScript.Generic.BaseTest;
import com.AutoScript.Generic.ExcelData;
import com.AutoScript.Page.LoginPage;

public class VerifyVersionTest extends BaseTest
{
	@Test(priority=3)
	public void testVerifyVersion()
	{
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String expectedVersion = ExcelData.getData(file_path, "TC03", 1, 0);
		
		LoginPage lp = new LoginPage(driver);
		
		//To verify login page
		lp.verifyPage(loginTitle);
		
		//verify version
		String actualVersion = lp.verifyVersion();
		
		Reporter.log("Actual version: "+actualVersion,true);
		Reporter.log("Expected version: "+expectedVersion,true);
		
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actualVersion, expectedVersion, "Version is not matching...");
		
		sa.assertAll();
		Reporter.log("Version is matching....",true);
	}
}
