package com.turtlemint.testCases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import org.testng.annotations.*;

import com.turtlemint.Utilities.ConfigFile;

public class TestBase {

	ConfigFile readConfig = new ConfigFile();
	public static WebDriver driver;
	public static Logger log;
	String turtlemintUrl =readConfig.getTurtlemintUrl();
	String flipkartUrl =readConfig.getFlipkartUrl();

	@BeforeClass
	public void setup()
	{

		System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriver());
		driver=new ChromeDriver();	
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();

		log = Logger.getLogger("Turtlemint Assignment Problem");
		PropertyConfigurator.configure("log4j.properties");
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
