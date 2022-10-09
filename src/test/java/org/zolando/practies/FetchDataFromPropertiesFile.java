package org.zolando.practies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertiesFile {

	public static String FetchValue(String Key) {
		//step 1---> convert physical file to java object
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("./src/test/resources/comman.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//step 2---> create object for properties
		Properties property = new Properties();
		//step 3---> load all the keys
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		// step 4---> fetch the data
		String value = property.getProperty(Key).trim();
		
		return value;
		
		//System.out.println(urlForUser);	
	}
	
}
