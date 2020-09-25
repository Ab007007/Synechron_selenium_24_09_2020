package com.synechron.actitime.basic.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class CreateCustomerUsingTestNG {

	

	WebDriver driver = null;
	
	@BeforeTest
	public void setup() {
		ActitimeUtils.getDriver();
		ActitimeUtils.launch();
		ActitimeUtils.login("admin", "manager");
	}
	
	@Test
	public void createCustomerTest() {
		ActitimeUtils.gotoTasksPage();
		ActitimeUtils.clickOnNewCustomer();
		ActitimeUtils.createCustomer("Syn-Customer_25_09_14", "Syn-Customer_25_09_14_Desc");
	}
	
	@AfterTest
	public void tearDown() {
		ActitimeUtils.logout();	
	}
	
}
