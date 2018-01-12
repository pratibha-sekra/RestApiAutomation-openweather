package com.wbl.base;

import java.util.Properties;

import org.testng.annotations.BeforeSuite;

import com.wbl.helper.ConfigUtils;

public class BaseApiTest {
	protected String endPoint;
	protected String Key;
	@BeforeSuite
	public void beforeSuit(){
		Properties prop= ConfigUtils.loadConfigFile("config.properties");
		endPoint= prop.getProperty("TSurl");
		Properties prop1= ConfigUtils.loadApiFile("apiKey.properties");
		Key= prop1.getProperty("ApiKey");
	}

}
