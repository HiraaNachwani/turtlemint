package com.turtlemint.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class POLifeInsurance {

	WebDriver driver;	
	public POLifeInsurance(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	@FindBy(how = How.XPATH, using="//div[@data-url='term-plan']")
	@CacheLookup
	WebElement TermLifePlan;

	public void ClickTermLifePlan()
	{
		String defaultWindow = driver.getWindowHandle();
		TermLifePlan.click();
		driver.switchTo().window(defaultWindow);
	}	


}
