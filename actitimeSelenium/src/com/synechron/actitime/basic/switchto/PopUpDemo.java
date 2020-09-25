package com.synechron.actitime.basic.switchto;

import org.openqa.selenium.WebDriver;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class PopUpDemo
{

	
	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch();
		ActitimeUtils.login("admin", "manager");
		ActitimeUtils.gotoTasksPage();
		ActitimeUtils.clickOnNewCustomer();
		ActitimeUtils.type("id", "customerLightBox_nameField", "Customer");
		ActitimeUtils.click("id", "customerLightBox_cancelBtn");
		ActitimeUtils.sleep();
		//click on cancel in the popup
		driver.switchTo().alert().dismiss();
		ActitimeUtils.sleep();
		ActitimeUtils.click("id", "customerLightBox_cancelBtn");
		ActitimeUtils.sleep();
		driver.switchTo().alert().accept();
		ActitimeUtils.sleep();
		ActitimeUtils.logout();
		
		
		
	}

	
}
