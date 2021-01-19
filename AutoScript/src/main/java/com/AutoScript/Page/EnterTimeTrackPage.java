package com.AutoScript.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.AutoScript.Generic.BasePage;

public class EnterTimeTrackPage extends BasePage
{
	//Declaration
	@FindBy(id="logoutLink")
	private WebElement logoutLink;
	
	//Initialization
	public EnterTimeTrackPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public void clickOnLogout()
	{
		logoutLink.click();
	}
}
