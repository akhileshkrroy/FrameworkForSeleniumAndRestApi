package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Utility {
	
	
	public static Properties loadProperties()
	{
		 Properties prop=null;
		try (InputStream input = new FileInputStream("localConf.properties")) {

             prop = new Properties();

            // load a properties file
            prop.load(input);

            // get the property value and print it out
//            System.out.println(prop.getProperty("db.url"));
//            System.out.println(prop.getProperty("db.user"));
//            System.out.println(prop.getProperty("db.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
		return prop;
	}

}
