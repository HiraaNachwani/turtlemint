package com.turtlemint.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class POHomePage {

	WebDriver driver;

	public POHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using="//div[@class='tab-cta tab-flex']/a[contains(text(),'Life')]")
	@CacheLookup
	WebElement LifeInsurance;

	public void ClickLifeInsurance()
	{
		String defaultWindow = driver.getWindowHandle();
		LifeInsurance.click();
		driver.switchTo().window(defaultWindow);

	}	

}
