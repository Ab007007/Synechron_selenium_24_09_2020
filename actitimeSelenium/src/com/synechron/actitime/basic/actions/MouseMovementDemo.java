package com.synechron.actitime.basic.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class MouseMovementDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch("https://www.flipkart.com/");
		
		WebDriverWait wait =  new WebDriverWait(driver, 30);
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(ActitimeUtils.getElement("xpath", "//button[@class='_2AkmmA _29YdH8']")));
		ele.click();

		WebElement electronicsTab = ActitimeUtils.getElement("xpath", "//span[text()='Electronics']");
		WebElement menTab = ActitimeUtils.getElement("xpath", "//span[text()='Men']");
		WebElement womenTab = ActitimeUtils.getElement("xpath", "//span[text()='Women']");
		WebElement sportsTab = ActitimeUtils.getElement("xpath", "//span[text()='Sports, Books & More']");
		WebElement homefurnitureTab = ActitimeUtils.getElement("xpath", "//span[text()='Home & Furniture']");

		Actions act = new Actions(driver);

		act.moveToElement(electronicsTab).perform();
		Thread.sleep(3000);
		act.moveToElement(womenTab).perform();
		Thread.sleep(3000);
		act.moveToElement(menTab).perform();
		Thread.sleep(3000);
		act.moveToElement(homefurnitureTab).perform();
		Thread.sleep(3000);
		act.moveToElement(sportsTab).perform();
	}
}
