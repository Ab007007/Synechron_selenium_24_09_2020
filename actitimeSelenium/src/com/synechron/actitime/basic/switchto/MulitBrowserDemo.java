package com.synechron.actitime.basic.switchto;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class MulitBrowserDemo {
	
	public static void main(String[] args) {
		
		WebDriver driver  = ActitimeUtils.getDriver();
		ActitimeUtils.launch();
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.click("xpath", "//div[contains(text(),'Help')]/ancestor::div[@class='popup_menu_container']");
		ActitimeUtils.click("linktext", "User Guide");
		
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> it = windowIds.iterator();
		
		String parent_wid = it.next();
		String child_wid = it.next();
		
		System.out.println("Parent window id " + parent_wid);
		System.out.println("Child window id " + child_wid);
		
		driver.switchTo().window(child_wid);
		
		List<WebElement> hyper_links = driver.findElements(By.xpath("//a"));
		
		for (WebElement hyper_link : hyper_links) {
			System.out.println(hyper_link.getText());
		}
		
		driver.close();
		
		driver.switchTo().window(parent_wid);
		
		
		ActitimeUtils.click("xpath", "//div[@class='userNameWrapper']");
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions
				.visibilityOf(ActitimeUtils.getElement("xpath","//div[contains(@class,'usersSelectorOnTT')]")));
		
		ActitimeUtils.click("xpath", "//span[text()='Kloss, Barbara']");
		
		ActitimeUtils.logout();
		
		
	}

}
