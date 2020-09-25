package com.synechron.actitime.basic.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.synechron.actitime.basic.testdata.TestData;
import com.synechron.actitime.basic.utils.ActitimeUtils;

public class CreateMultipleCustomer {

	

	WebDriver driver = null;
	
	
	 
	@BeforeTest
	@Parameters({"url","username","password","browser"})
	public void setup(String url, String un, String pwd, String browserType) {
		ActitimeUtils.getDriver(browserType);
		ActitimeUtils.launch(url);
		ActitimeUtils.login(un,pwd);
		ActitimeUtils.gotoTasksPage();
	}
	
	@Test(dataProviderClass = TestData.class, dataProvider = "customer_data")
	public void createCustomerTest(String cn, String cd) {
		ActitimeUtils.clickOnNewCustomer();
		ActitimeUtils.createCustomer(cn,cd);
	}
	
	@AfterTest
	public void tearDown() {
		ActitimeUtils.logout();	
	}
	
}
