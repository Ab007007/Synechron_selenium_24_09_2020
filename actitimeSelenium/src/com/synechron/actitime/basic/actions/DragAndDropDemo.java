package com.synechron.actitime.basic.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class DragAndDropDemo {
	
	public static void main(String[] args) {
		
		WebDriver driver = ActitimeUtils.getDriver();
		ActitimeUtils.launchApp("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		Actions act = new Actions(driver);
		
		System.out.println(ActitimeUtils.getElementText("id", "draggable"));
		System.out.println(ActitimeUtils.getElementText("id", "droppable"));
		
		act.dragAndDrop(ActitimeUtils.getElement("id", "draggable"), ActitimeUtils.getElement("id", "droppable")).perform();
	
		System.out.println(ActitimeUtils.getElementText("id", "draggable"));
		System.out.println(ActitimeUtils.getElementText("id", "droppable"));
		
		
	}

}
