package com.turtlemint.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFile {

	Properties properties;

	public ConfigFile() 
	{
		File src = new File("./Configuration/config.properties");
		try
		{
			FileInputStream fisObj = new FileInputStream(src);
			properties = new Properties();
			properties.load(fisObj);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public String getTurtlemintUrl() {

		String url=properties.getProperty("turtlemintUrl");
		return url;
	}

	public String getFlipkartUrl() {

		String url=properties.getProperty("flipkartUrl");
		return url;
	}

	public String getChromeDriver() {

		String driver=properties.getProperty("chromedriverPath");
		return driver;
	}

}
