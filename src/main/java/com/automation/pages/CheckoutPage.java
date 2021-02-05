package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {
	
public WebDriver driver;

	
	@FindBy(xpath="(.//span[@class='a-color-price hlb-price a-inline-block a-text-bold'])[1]")
	private WebElement itemPriceAtAddToCartPage;
	
	public CheckoutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	public String getItemCurrentPriceFromCheckoutPage()
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(itemPriceAtAddToCartPage));
		 return itemPriceAtAddToCartPage.getText();		
	}

}
