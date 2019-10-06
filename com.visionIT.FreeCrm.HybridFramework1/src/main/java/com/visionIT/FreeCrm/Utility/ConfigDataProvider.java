package com.visionIT.FreeCrm.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
public static Properties prop1;
	
	public ConfigDataProvider() {
		
		try {

			File fs = new File(".//Config//prop1.properties");
			FileInputStream fis = new FileInputStream(fs);
			prop1 = new Properties();
			prop1.load(fis);

		} catch (Exception e) {

			System.out.println("File not found :" + e.getMessage());
		}
	}
	
	public String getConfigProperties(String keyValue)
	{
		return prop1.getProperty(keyValue);		
	}
	public String getUserName()
	{
		return prop1.getProperty("uname");		
	}
	
	public String getUserpass()
	{
		return prop1.getProperty("upass");		
	}
	
	public String getChromeBrowser()
	{
		return prop1.getProperty("chBrowser");		
	}
	
	

}

	


