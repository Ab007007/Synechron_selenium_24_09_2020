package com.synechron.actitime.basic.autosuggestions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.actitime.basic.utils.WebDriverUtils;

public class AutoSuggestionsDemo 
{
	public static void main(String[] args) {
		
		WebDriver driver  =  WebDriverUtils.getDriver();
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("Synechron");
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[@class='erkvQe']"))));
		
			
		List<WebElement> auto_suggestions = driver.findElements(By.xpath("//ul/li[@role='presentation']"));
		
		System.out.println(auto_suggestions.size());
		
		for (WebElement suggestion : auto_suggestions)
		{
			System.out.println(suggestion.getText());
		}
		
		
	}
}
