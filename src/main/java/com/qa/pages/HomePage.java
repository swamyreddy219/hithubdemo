package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Super User, Software IT, Hyderabad HO')]")
	WebElement lintext;
	
	@FindBy(xpath="//span[text()='ADMINISTRATION']")
	WebElement adminLink;
	@FindBy(xpath="//span[text()='Admin']")
	WebElement Adminsubmenu;
	@FindBy(xpath="//span[text()='User']")
	WebElement users;
	
	@FindBy(xpath="//span[text()='TENDERING']")
	WebElement tenderingLink;
	
	@FindBy(xpath="//span[text()='PROJECT - CONTRACTS']")
	WebElement projContractLink;
	
	//initializing the page objects
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomepageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean validatinglinktext()
	{
		return lintext.isDisplayed();
	}
	
	public AdminPage clickOnadminlink()
	{
		
		//act.adminLink.moveToElement(Adminsubmenu).moveToElement(users).click().build().perform();
		adminLink.click();
		/*//Adminsubmenu.click();
		Actions act=new Actions(driver);
		//act.moveToElement(Adminsubmenu).click().build().perform();
		act.moveToElement(Adminsubmenu).click().moveToElement(users).build().perform();*/
	    return new AdminPage();
	}
	
	public TenderingPage clickOntenderingpage()
	{
		tenderingLink.click();
		return new TenderingPage();
	}
	public ProjContractPage clickOnprojcontractpage()
	{
		projContractLink.click();
		return new ProjContractPage();
	}

}
