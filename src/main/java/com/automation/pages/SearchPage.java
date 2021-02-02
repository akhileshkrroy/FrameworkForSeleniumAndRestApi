package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage{
    public WebDriver driver;
	
	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchBox;
	
	@FindBy(id="nav-search-submit-button")
	WebElement searchButton;
	
	@FindBy(xpath="(.//*[@class='a-section aok-relative s-image-fixed-height'])[1]")
	WebElement firstSearchedElement;
	
	@FindBy(xpath=".//span[@id='newBuyBoxPrice']")
	WebElement pricefirstSearchedElementPrice;
	
	@FindBy(id="add-to-cart-button")
	WebElement addToCart;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchText(String searchText)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys(searchText);
		
	}
	
	public void clickButton()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(searchButton));
		searchButton.click();
	}
	
	public void clickAddToCartButton()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(addToCart));
		addToCart.click();
	}
	
	public void clickFirstSearchResultElement()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(firstSearchedElement));
		firstSearchedElement.click();
	}
	
	public String getPrice()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(pricefirstSearchedElementPrice));
		 return pricefirstSearchedElementPrice.getText();		
	}

}
