package org.zolando.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class consist of reusable file
 * 
 * @author PREM
 *
 */
public class PropertyFileUtility {
	private String propertyFilePath;
	public PropertyFileUtility(String propertyFilePath) {
		this.propertyFilePath=propertyFilePath;
	}
	/**
	 * This method is used to get the value from the property file.
	 * @param propertyFilePath
	 * @param key
	 * @return
	 */
	public String getDataFromPropertyFile(String key) {
		Properties p = null;
		try {
			p = new Properties();
			p.load(new FileInputStream(propertyFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return p.getProperty(key);
	}
}
