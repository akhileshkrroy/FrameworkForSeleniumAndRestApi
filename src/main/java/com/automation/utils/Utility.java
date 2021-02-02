package com.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static Properties loadProperties() {
		Properties prop = null;
		try (InputStream input = new FileInputStream("localConf.properties")) {

			prop = new Properties();

			// load a properties file
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return prop;
	}

	public static double convertDollarToInt(String strPrice) {
		String sNumber = strPrice.substring(1);

		return Double.parseDouble(sNumber);

	}

	public static boolean priceMathces(int firstPrice, int secondPrice) {
		if (firstPrice == secondPrice)
			return true;
		else
			return false;

	}

	public static byte[] takeSnapShot(WebDriver webdriver) throws Exception {
		byte[] screenshot = null;
		screenshot = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.BYTES);

		return screenshot;
	}

}
