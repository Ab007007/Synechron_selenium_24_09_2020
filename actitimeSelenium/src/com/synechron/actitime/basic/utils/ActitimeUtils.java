package com.synechron.actitime.basic.utils;

import org.openqa.selenium.By;
import org.testng.Assert;

public class ActitimeUtils extends WebDriverUtils
{
	
	public static void validateTitle(String expectedtitle) {
		System.out.println("Validating title " + expectedtitle);
		Assert.assertEquals(driver.getTitle(), expectedtitle);
	}
	
	public static void launch(String url)
	{
		
		System.out.println(" Launching the application " + url);
		driver.get(url);
		validateTitle("actiTIME - Login");
	}
	public static void launchApp(String url)
	{
		
		System.out.println(" Launching the application " + url);
		driver.get(url);
	}

	
	public static void login(String un, String pwd) {
		
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pwd);
		driver.findElement(By.id("loginButton")).click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		validateTitle("actiTIME - Enter Time-Track");
	}
}
