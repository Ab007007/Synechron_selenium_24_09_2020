package com.synechron.actitime.basic.popup;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class HiddenDivisionPopUp {

	
	public static void main(String[] args) {
		
		ActitimeUtils.getDriver();
		
		ActitimeUtils.launch("http://formy-project.herokuapp.com/modal");
		
		ActitimeUtils.click("id", "modal-button");
		ActitimeUtils.sleep();
		System.out.println(ActitimeUtils.getElementText("id", "exampleModalLabel"));
		System.out.println(ActitimeUtils.getElementText("xpath", "//div[@class='modal-body']"));
	
	
		ActitimeUtils.waitAndclick("id", "close-button");
	
	
	}
}
