package com.synechron.actitime.basic.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.synechron.actitime.basic.utils.ActitimeUtils;
import com.synechron.actitime.basic.utils.WebDriverUtils;

public class SelectDemo {
	
	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch("http://formy-project.herokuapp.com/form");
		
		driver.findElement(By.id("first-name")).sendKeys("Aravinda");
		driver.findElement(By.id("last-name")).sendKeys("HB");
		driver.findElement(By.id("job-title")).sendKeys("Corporate Trainer");
		driver.findElement(By.id("radio-button-2")).click();
		driver.findElement(By.id("checkbox-1")).click();
		
		Select yoe = new Select(driver.findElement(By.id("select-menu")));
		yoe.selectByIndex(1); //0-1
		Thread.sleep(3000);
		yoe.selectByValue("4"); //10+
		Thread.sleep(3000);
		yoe.selectByVisibleText("2-4"); //2-4
			
		
		driver.findElement(By.id("datepicker")).sendKeys("09/24/2020");
		driver.findElement(By.xpath("//a[text()='Submit']")).click();
		
		WebElement success_msg = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
		System.out.println("Success message " + success_msg.getText());
	}

	
}
