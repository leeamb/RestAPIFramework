package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
	public Properties prop;
	
	public TestBase()  {
		try {
			prop= new Properties();
			FileInputStream ip = new FileInputStream("/Users/leena/eclipse-workspace/restapi/src/main/java/com/qa/config/config.properties");
			prop.load(ip);
			System.out.println(prop.getProperty("URL"));
		} catch (IOException e) {
			e.printStackTrace();
			}
	}

}
