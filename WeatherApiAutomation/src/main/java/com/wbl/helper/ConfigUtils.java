package com.wbl.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
	static Properties prop;
	public static Properties loadConfigFile(String fileName){
		 prop= new Properties();
		try {
			prop.load(new FileInputStream(Constants.path+fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	public static Properties loadApiFile(String fileName){
		 prop= new Properties();
		try {
			prop.load(new FileInputStream(Constants.path+fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
