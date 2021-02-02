package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{
	public WebDriver driver;
	
	@FindBy(xpath=".//a[@id='hlb-ptc-btn-native']")
	WebElement checkoutButton;
	
	@FindBy(xpath="(.//span[@class='a-color-price hlb-price a-inline-block a-text-bold'])[1]")
	WebElement itemPriceAtAddToCartPage;
	
	public CartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickCheckoutButton()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
		checkoutButton.click();
	}
	
	public String getItemCurrentPrice()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(itemPriceAtAddToCartPage));
		 return itemPriceAtAddToCartPage.getText();		
	}

}
