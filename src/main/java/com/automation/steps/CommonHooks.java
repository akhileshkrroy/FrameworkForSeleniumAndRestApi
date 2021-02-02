package com.automation.steps;

import org.openqa.selenium.WebDriver;

import com.automation.pages.BasePage;

import cucumber.api.Scenario;
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
	public void tearDown(Scenario scenario)
	{
		//we can write any information to cucumber report using this. or can capture screen shots and embed on failure
		scenario.write("Scenario Status :: " +scenario.getStatus());
		driver.close();
//		driver.quit();
	}

}
