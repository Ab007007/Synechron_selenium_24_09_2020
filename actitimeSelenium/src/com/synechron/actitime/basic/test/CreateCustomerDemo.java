package com.synechron.actitime.basic.test;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class CreateCustomerDemo extends ActitimeUtils
{

	
	public static void main(String[] args) 
	{
		getDriver();
		launch();
		login("admin", "manager");
		gotoTasksPage();
		clickOnNewCustomer();
		createCustomer("Syn-Customer_25_09_2", "Syn-Customer_25_09_2_Desc");
		logout();
	}
	
	
}
