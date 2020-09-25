package com.synechron.actitime.basic.utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

	public static WebDriver getRemoteDriver(String client_url, String type) {
		String url = client_url + "/wd/hub";

		switch (type) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			try {
				options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
				options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				options.addArguments("disable-infobars");
				driver = new RemoteWebDriver(new URL(url), options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;

		case "ff":
			FirefoxOptions foptions = new FirefoxOptions();
			try {
				foptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
				foptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
				foptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				foptions.addArguments("disable-infobars");
				driver = new RemoteWebDriver(new URL(url), foptions);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		case "edge":
			EdgeOptions eoptions = new EdgeOptions();
			try {
				eoptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
				eoptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
				eoptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				eoptions.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, "disable-infobars"); //addArguments();
				driver = new RemoteWebDriver(new URL(url), eoptions);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
		return driver;

	}

	public static WebDriver getDriver(String type) {
		System.out.println("Creatiing Web Driver" + type);
		switch (type) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			driver = new ChromeDriver();

			break;
		case "ff":
			System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
			driver = new FirefoxDriver();

			break;

		case "edge":
			System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
			driver = new EdgeDriver();

			break;

		default:
			System.out.println("Please contact framework developers " + type);
			break;
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;

	}

	public static WebElement getElement(String identifier, String value) {
		WebElement ele = null;
		System.out.println("---> Finding the element using " + identifier + " and " + value);
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
		System.out.println("-> Clicking on Webelement");

		WebElement ele = getElement(identifier, value);

		if (ele.isDisplayed() && ele.isEnabled()) {
			System.out.println("Element is displayed and enabled");
			ele.click();
		}
		System.out.println("-> Clicking on Webelement completed");

	}

	public static void waitAndclick(String identifier, String value) {
		System.out.println("-> Wait Clicking on Webelement");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement ele = wait.until(ExpectedConditions.visibilityOf(getElement(identifier, value)));

		if (ele.isDisplayed() && ele.isEnabled()) {
			System.out.println("Element is displayed and enabled");
			ele.click();
		}
		System.out.println("-> Clicking on Webelement completed");
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

	public static void selectCheckBox(String identifier, String value) {
		System.out.println("Clicking on Check box Webelement");

		WebElement ele = getElement(identifier, value);

		if (ele.isSelected()) {
			System.out.println("Checkbox is already selected not performing click");
		} else {
			ele.click();
		}

	}

}
