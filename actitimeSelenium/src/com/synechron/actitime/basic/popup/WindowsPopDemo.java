package com.synechron.actitime.basic.popup;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.synechron.actitime.basic.utils.ActitimeUtils;

public class WindowsPopDemo {

	static {
		try {
			System.out.println("Executing my popup handler");
			Runtime.getRuntime().exec("D:\\synechron_ws_24_09\\autoit\\handle_upload_popup.exe");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) throws IOException {
		
		WebDriver driver = ActitimeUtils.getDriver();
		
		ActitimeUtils.launch("http://formy-project.herokuapp.com/fileupload");

		ActitimeUtils.click("xpath", "//button[text()='Choose']");
		
		ActitimeUtils.sleep(6000);
		
		ActitimeUtils.click("xpath", "//button[text()='Reset']");
		
		//System.out.println(ActitimeUtils.getElementText("id", "file-upload-field"));
	}
}
