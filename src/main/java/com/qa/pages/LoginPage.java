package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//pageFactoty--OR
	@FindBy(name="tbUserName")
	WebElement username;
	
	@FindBy(name="tbPassword")
	WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[text()='Forgot Password?']")
	WebElement linktext;
	
	@FindBy(xpath="//img[@alt='company logo']")
	WebElement logo;
	
	//Initializing the page Objects
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validatePageTitle()
	{
		//hi this is changed 
		
		
		return driver.getTitle();
	}
	
    public boolean validateLogo()
    {
    	return logo.isDisplayed();
    }
    
    public String validatelinktext()
    {
    	return linktext.getText();
    }
    public HomePage login(String uname,String pwd)
    {
    	username.sendKeys(uname);
    	password.sendKeys(pwd);
    	loginBtn.click();
    	return new HomePage();
    	
    }
	
	
	
	
	
	
	
	
	
	

}
