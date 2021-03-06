package com.automation.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.automation.utils.Utility;

public class BasePage {

	// Declare the WebDriver
	public static WebDriver driver;
	static Properties prop = Utility.loadProperties();

	public static WebDriver getInstance() {
		if (driver == null) {
			String browser = prop.getProperty("browser");
			if ("chrome".equalsIgnoreCase(browser)) {

				//i am using mac machine
				String driverPath = System.getProperty("user.dir");
				System.setProperty("webdriver.chrome.driver", driverPath + "/chromedriver");

				driver = new ChromeDriver();
			} else {
				// other browsers can be added here
			}

		}
		return driver;
	}

	public static void navigateHomePage() {

		String Uri = prop.getProperty("uiuri");
		driver.get(Uri);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Long.parseUnsignedLong(prop.getProperty("implicitwait")),
				TimeUnit.SECONDS);
	}

}
