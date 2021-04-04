package com.turtlemint.testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.turtlemint.pageObjects.POFlipkartHome;

public class Problem_2 extends TestBase{

	@Test
	public void TC200_SearchProduct() throws InterruptedException
	{
		log.info("---------------- Starting Test TC200_SearchProduct ---------------- " );
		log.info("Open Flipkart URL");
		driver.get(flipkartUrl);

		log.info("Close Login Form");
		POFlipkartHome flipkart = new POFlipkartHome(driver);
		flipkart.closeLoginBtn();

		log.info("Enter the search text & click enter/submit");
		flipkart.Search("Books");

		log.info("Print All Items & All Respective URLS");
		List<WebElement> list = flipkart.getAllUrls();
		System.out.println("Total Books = " + list.size());
		for(WebElement element : list)
		{
			System.out.println("Book = "+element.getText()+ "  | Url = " +element.getAttribute("href"));

		}

	}
}
