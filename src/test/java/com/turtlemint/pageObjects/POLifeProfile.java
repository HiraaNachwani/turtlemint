package com.turtlemint.pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class POLifeProfile {

	WebDriver driver;	
	public POLifeProfile(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using="Radio-M")
	@CacheLookup
	WebElement GenderMale;

	@FindBy(how = How.ID, using="Radio-F")
	@CacheLookup
	WebElement GenderFemale;

	@FindBy(how = How.XPATH, using="//input[@placeholder='Enter Date']")
	@CacheLookup
	WebElement Date;

	@FindBy(how = How.ID, using="Radio-true")
	@CacheLookup
	WebElement SmokeOrChewTobaccoYes;

	@FindBy(how = How.ID, using="Radio-false")
	@CacheLookup
	WebElement SmokeOrChewTobaccoNo;

	@FindBy(how = How.XPATH, using="//div[@class='sc-eqIVtm cCBzET']")
	@CacheLookup
	WebElement AnnualIncome;

	@FindBy(how = How.XPATH, using="//*[text()='Next']")
	@CacheLookup
	WebElement NextBtn;	

	@FindBy(how = How.XPATH, using="//select[@class='sc-iQKALj gwKrYD'][1]")
	@CacheLookup
	WebElement Year;

	@FindBy(how = How.XPATH, using="//select[@class='sc-iQKALj gwKrYD'][2]")
	@CacheLookup
	WebElement Month;

	@FindBy(how = How.XPATH, using="//div[@class='sc-eqIVtm cCBzET']")
	@CacheLookup
	WebElement SumAssuredAmount;

	@FindBy(how = How.NAME, using="customerName")
	@CacheLookup
	WebElement Name;

	@FindBy(how = How.NAME, using="paidUserMobile")
	@CacheLookup
	WebElement Mobile;

	@FindBy(how = How.NAME, using="paidUserEmail")
	@CacheLookup
	WebElement Email;

	@FindBy(how = How.XPATH, using="//button[text()='OK, GOT IT!']")
	@CacheLookup
	WebElement OkGotItBtn;	




	public void SelectGender(String gender)
	{
		if(gender =="Male")
		{
			GenderMale.click();
		}
		else if(gender =="Female")
		{
			GenderFemale.click();
		}
		else {
			System.out.println("Invalid Gender Selection");
		}
	}


	public void SetDate(String year, String month, String date)
	{
		Date.click();
		Select s = new Select(Year);
		s.selectByVisibleText(year);
		s = new Select(Month);
		s.selectByVisibleText(month);
		driver.findElement(By.xpath("//div[@class='react-datepicker__day react-datepicker__day--00"+date+"']")).click();
	}

	public void SelectSmokeOrChewTobacco(String smokeOrChewTobacco)
	{
		if(smokeOrChewTobacco =="Yes")
		{
			SmokeOrChewTobaccoYes.click();
		}
		else if(smokeOrChewTobacco =="No")
		{
			SmokeOrChewTobaccoNo.click();
		}
	}

	public void SelectAnnuanlIncome(String annualIncome)
	{
		AnnualIncome.click();
		driver.findElement(By.xpath("//div[@class='sc-eqIVtm cCBzET']/span[text()='"+annualIncome+"']")).click();

	}

	public void SelectNextBtn()
	{
		NextBtn.click();
	}

	public void SelectSumAssuredAmount(String amount)
	{
		AnnualIncome.click();
		driver.findElement(By.xpath("//div[@class='sc-eqIVtm cCBzET']/span[text()='"+amount+"']")).click();

	}

	public void SetName(String name)
	{
		Name.sendKeys(name);
	}

	public void SetEmail(String email)
	{
		Email.sendKeys(email);
	}

	public void SetMobile(String mobile)
	{
		Mobile.sendKeys(mobile);
	}

	public void SelectOkGotItBtn()
	{
		WebDriverWait w= new WebDriverWait(driver, 20);
		w.ignoring(NoSuchElementException.class);
		w.until(ExpectedConditions.visibilityOf(OkGotItBtn));
		w.until(ExpectedConditions.elementToBeClickable(OkGotItBtn));
		OkGotItBtn.click();
	}




}
