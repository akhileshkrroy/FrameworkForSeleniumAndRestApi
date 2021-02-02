package com.automation.steps;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.automation.pages.BasePage;
import com.automation.pages.CartPage;
import com.automation.pages.CheckoutPage;
import com.automation.pages.SearchPage;
import com.automation.utils.Utility;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class PriceValidationSteps {
	public WebDriver driver;
	
	Map<String,Double> map=new HashMap<String,Double>();
	
	@Given("^user navigates to search page$")
	public void userNavigates()
	{
		driver=BasePage.getInstance();
		BasePage.navigateHomePage();
	}

	@And("^use searches for \"([^\"]*)\"$")
	public void userSearches(String str)
	{
		driver=BasePage.getInstance();
		SearchPage searchPage=new SearchPage(driver);
		//search for the item
		searchPage.searchText(str);
		
		//click on search icon
		searchPage.clickButton();
		
		//click on first item
		searchPage.clickFirstSearchResultElement();
		
		//Get Price of first item and store in map for future price validation 
		String price=searchPage.getPrice();
		Assert.assertNotNull(price);
		System.out.println(price);
		map.put("priceAtSearch", Utility.convertDollarToInt(price));
		map.entrySet().forEach(e->System.out.println(e));
		
		//click on Add to cart
		searchPage.clickAddToCartButton();
	}
	
	@And("^verify item price at search and add to cart matches$")
	public void verifyItemPriceAtAddToCart()
	{
		driver=BasePage.getInstance();
		CartPage cartPage=new CartPage(driver);
		
		//Get Price of first item at add to cart page and store in map for future price validation 
		String price=cartPage.getItemCurrentPrice();
		Assert.assertNotNull(price);
		System.out.println(price);
		map.put("priceatAddToCart", Utility.convertDollarToInt(price));
		map.entrySet().forEach(e->System.out.println(e));
		
		//Validate search price and Add Cart Page Price Matches
		
		Assert.assertEquals(map.get("priceatAddToCart"), map.get("priceAtSearch"));
		
		//click on checkout button at Add to Cart Page
		cartPage.clickCheckoutButton();
	}
	
	@And("^verify item price at search and checkout out page matches$")
	public void verifyItemPriceAtCheckout()
	{
		driver=BasePage.getInstance();
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		
		
		//*******looks like after clicking checkout we need to login to verify price-not sure do we want do this here
		//   But below is the code which can be used to validate if we login******************
		
//		String price=checkoutPage.getItemCurrentPriceFromCheckoutPage();
//		Assert.assertNotNull(price);
//		map.put("priceatCheckoutPage", Utility.convertDollarToInt(price));
//		
//		//Validate search price and Add Cart Page Price Matches
//		
//		Assert.assertEquals(map.get("priceatCheckoutPage"), map.get("priceAtSearch"));
		
	}
}
