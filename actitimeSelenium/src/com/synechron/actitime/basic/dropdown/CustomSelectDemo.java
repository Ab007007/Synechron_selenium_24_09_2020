package com.synechron.actitime.basic.dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class CustomSelectDemo {

	public static void main(String[] args) {

		WebDriver driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch("http://localhost/login.do");
		ActitimeUtils.login("admin", "manager");
		driver.findElement(By.xpath("//div[@class='userNameWrapper']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.visibilityOf(driver.findElement(By.xpath("//div[contains(@class,'usersSelectorOnTT')]"))));
		
		
		driver.findElement(By.xpath("//span[text()='Kloss, Barbara']")).click();
	}
}
