package com.qa.utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;

	public Properties getProperty() throws IOException
	{
		prop = new Properties();
		FileInputStream f1 = new FileInputStream("./src/test/resources/config.properties");
		prop.load(f1);
		return prop;
	}
}
