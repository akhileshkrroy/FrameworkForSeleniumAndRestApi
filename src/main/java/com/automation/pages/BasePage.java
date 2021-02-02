package com.automation.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

	// Declare the WebDriver
	public static WebDriver driver;

	public static WebDriver getInstance() {
		if (driver == null) {

			String filePath = System.getProperty("user.dir");
			System.out.println(filePath);
//        System.setProperty("webdriver.chrome.driver", filePath + "/src/test/resources/chromedriver");

			System.setProperty("webdriver.chrome.driver", "/Users/softwares/chromedriver");
			driver = new ChromeDriver();
			
		}
		return driver;
	}
	
	public static void navigateHomePage()
	{
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
