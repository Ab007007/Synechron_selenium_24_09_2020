package com.synechron.actitime.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HelloWorldSelenium {
	public static void main(String[] args) {
		
		
		System.out.println("Hello all welcome to Selenium Session");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver =  new ChromeDriver();
	}

}
