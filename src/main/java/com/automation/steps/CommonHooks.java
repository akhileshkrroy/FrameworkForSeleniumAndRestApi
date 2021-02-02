package com.automation.steps;

import org.openqa.selenium.WebDriver;

import com.automation.pages.BasePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class CommonHooks {
	public WebDriver driver;
	
	@Before("@web")
	public void webSetup()
	{
		driver=BasePage.getInstance();
		
	}
	
	@After("@web")
	public void tearDown()
	{
		driver.close();
//		driver.quit();
	}

}
