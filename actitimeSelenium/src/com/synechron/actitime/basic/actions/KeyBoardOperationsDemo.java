package com.synechron.actitime.basic.actions;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class KeyBoardOperationsDemo {

	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch("http://localhost/login.do");
		
		Actions act = new Actions(driver);
		
		act.sendKeys("admin").perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.TAB).perform();
		Thread.sleep(3000);
		act.sendKeys("manager").perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.ENTER).perform();
	}
}
