package com.synechron.actitime.basic.dropdown;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class FrameElementsDemo {
	public static void main(String[] args) {
		WebDriver driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch("https://jqueryui.com/droppable/");
		
		//driver.switchTo().frame(0);
//		driver.switchTo().frame("valueofname");
		driver.switchTo().frame(ActitimeUtils.getElement("tagname", "iframe"));
		
		Actions act = new Actions(driver);

		System.out.println(ActitimeUtils.getElementText("id", "draggable"));
		System.out.println(ActitimeUtils.getElementText("id", "droppable"));

		act.dragAndDrop(ActitimeUtils.getElement("id", "draggable"), ActitimeUtils.getElement("id", "droppable"))
				.perform();

		System.out.println(ActitimeUtils.getElementText("id", "draggable"));
		System.out.println(ActitimeUtils.getElementText("id", "droppable"));
		
		driver.switchTo().defaultContent();
		ActitimeUtils.click("linktext", "Sortable");
	}
}
