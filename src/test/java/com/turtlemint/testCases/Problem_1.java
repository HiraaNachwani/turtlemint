package com.turtlemint.testCases;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.turtlemint.pageObjects.POHomePage;
import com.turtlemint.pageObjects.POInsurer;
import com.turtlemint.pageObjects.POLifeInsurance;
import com.turtlemint.pageObjects.POLifeProfile;

public class Problem_1 extends TestBase{

	@Test
	public void TC100_LifeInsuranceTest() throws InterruptedException
	{
		log.info("---------------- Starting Test TC100_LifeInsuranceTest ---------------- " );
		log.info("Open turtlemint URL");
		driver.get(turtlemintUrl);
		POHomePage homePage = new POHomePage(driver);

		log.info("Click Life Insurance button");
		homePage.ClickLifeInsurance();
		log.info("Assert title of the Life Insurance Policies page ");
		Assert.assertEquals(driver.getTitle(),"Life Insurance Policies: Compare & Buy Best Life Insurance Plans (2020)");

		log.info("Click Term Life Plan button");
		POLifeInsurance lifeInsurance = new POLifeInsurance(driver);
		lifeInsurance.ClickTermLifePlan();

		log.info("Enter details in life profile section 1 & Click Next Button");
		POLifeProfile lifeProfile = new POLifeProfile(driver);
		lifeProfile.SelectGender("Male");
		lifeProfile.SetDate("1996", "Mar", "1");
		lifeProfile.SelectSmokeOrChewTobacco("No");
		lifeProfile.SelectAnnuanlIncome("5 Lac to 7 Lac");
		lifeProfile.SelectNextBtn();

		log.info("Enter details in life profile section 2 & Click Next Button");
		lifeProfile = new POLifeProfile(driver);
		lifeProfile.SelectSumAssuredAmount("₹1 Crs");
		lifeProfile.SelectNextBtn();

		log.info("Enter details in life profile section 3 & Click Next Button");
		lifeProfile = new POLifeProfile(driver);
		lifeProfile.SetName("Test");
		lifeProfile.SetMobile("9999955555");
		lifeProfile.SetEmail("Test@xyz.com");
		lifeProfile.SelectNextBtn();

		log.info("Wait for OK, GOT IT! Button to Visible & Clickable then Click");
		lifeProfile = new POLifeProfile(driver);
		lifeProfile.SelectOkGotItBtn();

		log.info("Click on View Details Button");
		POInsurer Insurer = new POInsurer(driver);
		Insurer.ClickOnViewDetails("TATAAIALI-Maha Raksha Supreme");

		log.info("Print URL of the Insurer page");
		Insurer = new POInsurer(driver);
		System.out.println(Insurer.getUrl());

	}

}
