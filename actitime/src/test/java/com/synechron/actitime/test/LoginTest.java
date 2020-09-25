package com.synechron.actitime.test;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.synechron.actitime.page.DashboardPage;
import com.synechron.actitime.page.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	
	WebDriver driver = null;
	LoginPage lp = null;
	DashboardPage dp = null;
	ExtentReports reports = null;
	ExtentTest test = null;
	String dateTimeStamp = null;
	
	@BeforeSuite
	public void setupReport() {

		dateTimeStamp = new Date().toString().replace(" ", "_").replace(":", "_");
	
		reports = new ExtentReports("reports\\TestExecutionReport" + dateTimeStamp + ".html");
		
	}
	
	@AfterSuite
	public void saveReports() {
		reports.flush();
		
	}
	
	@BeforeTest
	public void preCondition() {
		test = reports.startTest("preCondition");
		test.log(LogStatus.INFO	, "Pre condition is executed ");
		
		WebDriverManager.chromedriver().setup();
		test.log(LogStatus.INFO	, "Downloaded required driver executabel by Webdriver Manager ");
		
		driver =  new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO	, "Driver object is crated ");
		
		lp = new LoginPage(driver);
		dp = new DashboardPage(driver);
		test.log(LogStatus.PASS, "Created page class objects successfully");
	//	reports.startReporter(reporterType, filePath)
		reports.endTest(test);
	}
	
	@BeforeMethod
	public void launch() {
		test = reports.startTest("Launch" );
		test.log(LogStatus.INFO, "Launching the applciton ");
		driver.get("http://localhost/login.do");
		
	}
	
	@Test(priority = 1)
	public void loginWithValidCredentials() {
		test = reports.startTest("loginWithValidCredentials");// , "Automation");
		test.log(LogStatus.INFO, "Entering UserName ");
		lp.enterUserName("admin");
		test.log(LogStatus.INFO, "Entering Password ");
		lp.enterPassword("manager");
		test.log(LogStatus.INFO, "Clicking on Login");
		
		lp.clickOnLogin();
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		test.log(LogStatus.PASS, "successfully logged in");
		dp.logout();
		test.log(LogStatus.PASS, "successfully logged out of the application");
		
	}
	
	@Test(priority = 3)
	public void loginWithEmptyCredentials() {
		test = reports.startTest("loginWithEmptyCredentials");
		test.log(LogStatus.INFO, "Entering UserName ");
		lp.enterUserName("");
		test.log(LogStatus.INFO, "Entering Password ");
		lp.enterPassword("");
		test.log(LogStatus.INFO, "Clicking on Login");
		
		lp.clickOnLogin();
		test.log(LogStatus.FAIL, "NOT successfully logged in");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		test.log(LogStatus.PASS, "successfully logged in");
		dp.logout();
		test.log(LogStatus.PASS, "successfully logged out of the application");
		
	}
	
	@Test(priority = 2)
	public void testLoginWithInValidCredentials() {
		test = reports.startTest("testLoginWithInValidCredentials");
		test.log(LogStatus.INFO, "Entering UserName ");
		lp.enterUserName("adsfasdf");
		test.log(LogStatus.INFO, "Entering Password ");
		lp.enterPassword("asfdasdf");
		test.log(LogStatus.INFO, "Clicking on Login");
		
		lp.clickOnLogin();
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
	}
	
	@AfterMethod
	public void checkStatus(ITestResult result) throws IOException 
	{
		if(result.getStatus() == ITestResult.FAILURE) {
			
			 TakesScreenshot ss = (TakesScreenshot) driver;
			 File srcFile = ss.getScreenshotAs(OutputType.FILE);
			 
			 FileUtils.copyFile(srcFile, new File("ss\\ScreenShot_"  +dateTimeStamp+".png"));
			 
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
