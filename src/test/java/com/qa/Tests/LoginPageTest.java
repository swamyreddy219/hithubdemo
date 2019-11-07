package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		Initialization();
		loginpage=new LoginPage();
	}
	@Test(priority=1)
	public void loginpageTitleTest()
	{
		String title=loginpage.validatePageTitle();
		Assert.assertEquals(title, "","the titles are not matched");
	}
	@Test(priority=2)
	public void logoImageTest()
	{
		boolean logo=loginpage.validateLogo();
	    Assert.assertTrue(logo);
	}
	@Test(priority=3)
	public void loginTest()
	{
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=4)
	public void linktextTest()
	{
		String linktext=loginpage.validatelinktext();
	    Assert.assertEquals(linktext, "Forgot Password?");
	}
	@AfterMethod
	public void teardown()
	
	{
		driver.quit();		
	}
	
}
