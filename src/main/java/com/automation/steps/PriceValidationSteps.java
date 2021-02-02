package com.automation.steps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.automation.pages.BasePage;
import com.automation.pages.HomePage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class PriceValidationSteps {
	public WebDriver driver;
	
	Map<String,Integer> map=new HashMap<String,Integer>();
	
	@Given("^user navigates to search page$")
	public void userNavigates()
	{
		System.out.println("user Logs in");
//		driver=BasePage.getInstance();
		BasePage.navigateHomePage();
	}

	@And("use searches for \"([^\"]*)\"$")
	public void userSearches(String str)
	{
		driver=BasePage.getInstance();
		HomePage homepage=new HomePage(driver);
		homepage.searchText(str);
		homepage.clickButton();
		homepage.clickFirstSearchResultElement();
//		String price=homepage.getPrice();
//		Assert.assertTrue()
//		map.put("priceatsearch", Integer.parseInt(price));
	}
}
