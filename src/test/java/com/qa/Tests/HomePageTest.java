package com.qa.Tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AdminPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProjContractPage;
import com.qa.pages.TenderingPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	AdminPage adminpage;
	TenderingPage tenderingpage;
	ProjContractPage projcontractpage;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		Initialization();
		loginpage=new LoginPage();
		adminpage=new AdminPage();
		tenderingpage=new TenderingPage();
		projcontractpage=new ProjContractPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyhomepagetitleTest()
	{
		String homepagetitle=homepage.verifyHomepageTitle();
		Assert.assertEquals(homepagetitle, "");
	}
	@Test(priority=2)
	public void validatelinktextTest()
	{
		boolean text=homepage.validatinglinktext();
		Assert.assertTrue(text);
	}
	
	@Test(priority=3)
	public void adminlinkTest() throws InterruptedException
	{
		adminpage=homepage.clickOnadminlink();
	Thread.sleep(5000);	
	}
	
	
	@Test(priority=4)
	public void tenderinglinkTest()
	{
		tenderingpage=homepage.clickOntenderingpage();
	}
	@Test(priority=5)
	public void projcontractlinkTest()
	{
		projcontractpage=homepage.clickOnprojcontractpage();
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	

}
