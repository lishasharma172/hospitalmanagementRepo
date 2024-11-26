package com.medicover.hms.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class FileUtility {
public String getDataFromPropertyFile(String key) throws Throwable {
	FileInputStream fis=new FileInputStream("./src/test/resources/propFile.properties");
	Properties prop=new Properties();
	prop.load(fis);
	
	String data=prop.getProperty(key);
	return data;
}
}
