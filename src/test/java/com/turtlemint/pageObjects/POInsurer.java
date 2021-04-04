package com.turtlemint.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class POInsurer {

	WebDriver driver;

	public POInsurer(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	public void ClickOnViewDetails(String insurer)
	{
		driver.findElement(By.xpath("//button[@data-auto='viewdetail-"+insurer+"']")).click();
	}

	public String getUrl()
	{
		return driver.getCurrentUrl();
	}
}
