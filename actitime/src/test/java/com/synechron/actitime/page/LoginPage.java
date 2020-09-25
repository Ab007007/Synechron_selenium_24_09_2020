package com.synechron.actitime.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public  LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "username")
	WebElement textUsername;
	
	@FindBy(name = "pwd")
	WebElement textPassword;
	
	@FindBy(id = "loginButton")
	WebElement loginButton;
	
	
	public void enterUserName(String name)
	{
		textUsername.sendKeys(name);
	}
	
	public void enterPassword(String pw)
	{
		textPassword.sendKeys(pw);
	}
	
	public void clickOnLogin()
	{
		loginButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void login(String un, String pw)
	{
		enterUserName(un);
		enterPassword(pw);
		clickOnLogin();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	
	
}
