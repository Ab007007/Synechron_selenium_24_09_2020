package com.synechron.actitime.basic.dropdown;

import javax.print.attribute.standard.Media;
import javax.swing.text.MutableAttributeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class MultiSelectDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = ActitimeUtils.getDriver();
		
		ActitimeUtils.launch("file:///D:/synechron_ws_24_09/html/multiSelect.html");
		
		 Select multiSelect = new Select(driver.findElement(By.tagName("select")));
		
		multiSelect.selectByIndex(0);
		Thread.sleep(2000);
		multiSelect.selectByValue("mercedes");
		Thread.sleep(2000);
		multiSelect.selectByVisibleText("Audi");
		Thread.sleep(2000);
		multiSelect.deselectByIndex(3);
		Thread.sleep(2000);
		multiSelect.deselectByVisibleText("Mercedes");
		Thread.sleep(2000);
		multiSelect.deselectByValue("volvo");
		Thread.sleep(2000);
		
		multiSelect.selectByIndex(0);
		Thread.sleep(2000);
		multiSelect.selectByValue("mercedes");
		Thread.sleep(2000);
		multiSelect.selectByVisibleText("Audi");
		Thread.sleep(2000);
		multiSelect.deselectAll();
	}
}
