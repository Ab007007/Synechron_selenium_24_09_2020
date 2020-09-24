package com.synechron.actitime.basic.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtils {

	public static WebDriver driver = null;

	public static WebDriver getDriver() {
		System.out.println("Creatiing Web Driver");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public static WebElement getElement(String identifier, String value) {
		WebElement ele = null;
		System.out.println("Finding the element using " + identifier + " and " + value);
		switch (identifier.toLowerCase()) {
		case "id":
			ele = driver.findElement(By.id(value));
			break;

		case "name":
			ele = driver.findElement(By.name(value));
			break;

		case "classname":
			ele = driver.findElement(By.className(value));
			break;

		case "tagname":
			ele = driver.findElement(By.tagName(value));
			break;

		case "linktext":
			ele = driver.findElement(By.linkText(value));
			break;

		case "partiallinktext":
			ele = driver.findElement(By.partialLinkText(value));
			break;

		case "css":
			ele = driver.findElement(By.cssSelector(value));
			break;

		case "xpath":
			ele = driver.findElement(By.xpath(value));
			break;

		default:
			ele = null;
			System.out.println("Please check ur identifier");
			break;
		}

		return ele;
	}

	public static void click(String identifier, String value) {
		System.out.println("Clicking on Webelement");

		WebElement ele = getElement(identifier, value);

		if (ele.isDisplayed() && ele.isEnabled()) {
			System.out.println("Element is displayed and enabled");
			ele.click();
		}
	}

	public static void type(String identifier, String value, String text) {
		System.out.println("Typing on Webelement " + text);

		WebElement ele = getElement(identifier, value);

		if (ele.isDisplayed() && ele.isEnabled()) {
			System.out.println("Element is displayed and enabled");
			ele.sendKeys(text);
		}
	}

	
	public static String getElementText(String identifier, String value) {
		System.out.println("getElementText on Webelement");
		String texttoReturn = null;
		WebElement ele = getElement(identifier, value);

		if (ele.isDisplayed() && ele.isEnabled()) {
			System.out.println("Element is displayed and enabled");
			texttoReturn = ele.getText();
		}
		
		return texttoReturn;
		
	}

	public static void selectCheckBox(String identifier, String value)
	{
		System.out.println("Clicking on Check box Webelement");

		WebElement ele = getElement(identifier, value);
		
		if(ele.isSelected()) {
			System.out.println("Checkbox is already selected not performing click");
		}
		else {
			ele.click();
		}

		
	}
	
	
}
