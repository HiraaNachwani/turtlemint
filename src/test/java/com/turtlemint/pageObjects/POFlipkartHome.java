package com.turtlemint.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class POFlipkartHome {
	
	WebDriver driver;

	public POFlipkartHome(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using="//button[@class='_2KpZ6l _2doB4z']")
	@CacheLookup
	WebElement closeLoginBtn;

	@FindBy(how = How.XPATH, using="//input[@placeholder='Search for products, brands and more']")
	@CacheLookup
	WebElement SearchTxt;
	
	@FindBy(how = How.XPATH, using="//button[@type='submit']")
	@CacheLookup
	WebElement SubmitBtn;
	
	@FindBy(how = How.XPATH, using="//a[@class='s1Q9rs']")
	@CacheLookup
	WebElement RelevantProduct;
	
	public void closeLoginBtn()
	{
		closeLoginBtn.click();
	}


	public void Search(String searchTxt)
	{
		SearchTxt.sendKeys(searchTxt);
		SubmitBtn.click();
	}
	
	public List<WebElement> getAllUrls() {
		
		List<WebElement> list = driver.findElements(By.xpath("//a[@class='s1Q9rs']"));
		return list;
	}
	
}
