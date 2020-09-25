package com.synechron.actitime.basic.utils;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ActitimeUtils extends WebDriverUtils
{
	
	public static void validateTitle(String expectedtitle) {
		System.out.println("Validating title " + expectedtitle);
		Assert.assertEquals(driver.getTitle(), expectedtitle);
	}
	
	public static void launch(String... url)
	{
		if(url.length>0) {
			System.out.println(" Launching the application " + url[0]);
			driver.get(url[0]);
		}
		else {
			System.out.println(" Launching Actitime application " );
			driver.get("http://localhost/login.do");
			validateTitle("actiTIME - Login");
		}
		
		
	}
	/*
	 * public static void launchApp(String url) {
	 * 
	 * System.out.println(" Launching the application " + url); driver.get(url); }
	 */
	
	public static void login(String un, String pwd) {
		System.out.println("Login to actitime applciaton using " + un + " and " + pwd);
		type("id", "username", un);
		type("name", "pwd", "manager");
		click("id", "loginButton");
		sleep(4000);
		validateTitle("actiTIME - Enter Time-Track");
	}
	
	public static void gotoTasksPage() {
		System.out.println("Click on Tasks tab and validate the page");
		click("xpath", "//a[contains(@href,'task')]");
		validateTitle("actiTIME - Task List");
	}
	
	
	
	public static void clickOnNewCustomer() {
		System.out.println("Click on Add New->+ New Custoomre Button On Tasks page");
		
		click("xpath", "//div[@id='cpTreeBlock']//div[@class='addNewButton']");
		click("xpath", "//div[contains(text(),'New Customer')]");
	}
	
	
	public static void sleep(long...ls )
	{
		System.out.println("Waiting to demonstrate.. no harm to remove this");
		try {
			if(ls.length > 0) {
				Thread.sleep(ls[0]);
			}
			else
			{
				Thread.sleep(3000);
			}
		}catch(Exception ex) {
			System.out.println("Waiting Excepiton");
		}
		
	}
	
	
	public static void logout() {
		System.out.println("Logging out of the application and closing the browser");
		click("id", "logoutLink");
		driver.close();
		
	}
	
	
}
