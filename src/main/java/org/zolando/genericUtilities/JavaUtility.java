package org.zolando.genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class consist of reusable methods
 * 
 * @author PREM
 *
 */
public class JavaUtility {
	/**
	 * This method used to get random number
	 * 
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		return new Random().nextInt(limit);
	}
	
	public String getRandomNuberInString(int limit) {
		int d = new Random().nextInt(limit);
		String s=""+d;
		return s;
	}
	/**
	 * This method is used to convert data type
	 * @param data
	 * @param statargy
	 * @return object
	 */
	public Object convertStringToAnyDataType(String data, DataType statargy) {
		Object obj = null;
		if (statargy.toString().equalsIgnoreCase("long")) {
			obj = Long.parseLong(data);
		} else if (statargy.toString().equalsIgnoreCase("int")) {
			obj = Integer.parseInt(data);
		} else if (statargy.toString().equalsIgnoreCase("double")) {
			obj = Double.parseDouble(data);
		}
		return obj;
	}
	
	/**
	 * This method is used to get the current data and time in "dd_MM_yyyy_hh_mm_ss" form
	 * @return
	 */
	public String getCurrentDateAndTime() {
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return dateFormat.format(date);
	}	
}
