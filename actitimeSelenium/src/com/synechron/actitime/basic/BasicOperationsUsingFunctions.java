package com.synechron.actitime.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.synechron.actitime.basic.utils.ActitimeUtils;
import com.synechron.actitime.basic.utils.WebDriverUtils;

public class BasicOperationsUsingFunctions {
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch("http://formy-project.herokuapp.com/form");
		
		//driver.findElement(By.id("first-name")).sendKeys("Aravinda");
		ActitimeUtils.type("id", "first-name", "Aravinda");
		ActitimeUtils.type("id", "last-name", "HB");
		ActitimeUtils.type("id", "job-title", "Corporate Trainer");
		Thread.sleep(5000);
		ActitimeUtils.selectCheckBox("id", "radio-button-2");
		ActitimeUtils.selectCheckBox("id", "checkbox-1");
		ActitimeUtils.type("id", "datepicker", "09/24/2020");
		
		ActitimeUtils.click("id", "//a[text()='Submit']");
		
		
		String success_msg = ActitimeUtils.getElementText("xpath", "//div[@class='alert alert-success']"); //driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		System.out.println("Success message " + success_msg);
	}

	
}
