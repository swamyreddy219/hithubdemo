package com.qa.base;


import java.io.FileInputStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	public TestBase() 
	{
		try{
		prop=new Properties();
		FileInputStream fis=new FileInputStream("C://Users//swamy//WorkSpace//com.Nirmana//src//main//java//com//qa//config//config.properties");
		prop.load(fis);
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
			
		}
	}
	
	public void Initialization()
	{
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "C://Users//swamy//Downloads//chromedriver_win32 (1)//chromedriver.exe");
		driver=new ChromeDriver();
		}
		else if(browsername.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C://Users//swamy//Downloads//geckodriver-v0.24.0-win64//geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("Driver is not Available");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://sispl.nirmana.co.in/");
		
	}

}
