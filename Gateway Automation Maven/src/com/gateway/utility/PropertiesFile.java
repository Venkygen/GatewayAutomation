package com.gateway.utility;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesFile {

	public static String GetProperty(String Key) {
		try {

			FileReader reader = new FileReader("E:/GatewayAutomation/Gateway Automation/src/datafile.properties");
			Properties properties = new Properties();
			properties.load(reader);

			return properties.getProperty(Key);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String GetFile(String Key) {
		try {

			Properties prop = new Properties();
			prop.load(PropertiesFile.class.getClass().getClassLoader()
					.getResourceAsStream("E:/GatewayAutomation/Gateway Automation/src/datafile.properties"));
			String fileName = prop.get("Key").toString();

			// FileReader reader = new FileReader("E:/GatewayAutomation/Gateway
			// Automation/src/datafile.properties");
			// Properties properties = new Properties();
			// properties.load(reader);

			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
