package com.synechron.actitime.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptDemo {

	
	WebDriver driver = null;
	@Test
	public void executeJS() {
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://formy-project.herokuapp.com/scroll");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	//	js.executeScript("window.scrollTo(0, 1000);");
		js.executeScript("elements[0].scrollIntoView();", driver.findElement(By.id("name")));
		
		
	}
}
