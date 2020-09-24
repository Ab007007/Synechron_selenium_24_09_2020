package com.synechron.actitime.basic.utils;

public class ActitimeUtils extends WebDriverUtils
{
	
	
	public static void launch(String url)
	{
		System.out.println(" Launching the application " + url);
		driver.get(url);
	}

}
