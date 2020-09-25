package com.synechron.actitime.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {

	public DashboardPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "logoutLink")
	WebElement linkLogout;
	
	
	public void logout() {
		linkLogout.click();
	}
	
	
	
}
