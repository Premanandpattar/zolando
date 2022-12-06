package org.zolando.practies;

import java.util.List;
import java.util.Scanner;

import org.zolando.genericUtilities.DataBaseUtility;

import junit.framework.Assert;

public class DataBaseSenario {

	
	public static void main(String[] argu) {
		DataBaseUtility db = new DataBaseUtility();
		db.openDBConnection("jdbc:mysql://localhost:3306/test", "root", "root");
		List<String> empNames = db.getDataFromDataBase("select * from employee",
				"empName");
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter name");
		String empName = scan.next();
		if (empNames.contains(empName)) {
			System.out.println("Employee name is present in data base");
		}else {
			System.out.
			println("Employee name is not present in employee table should want to add? please enter Yes or No");
			String value = scan.next();
			if (value.equalsIgnoreCase("Yes")) {
				String status = db.
				setDataToDataBase("insert into employee values('"+empName+"')");
				Assert.assertEquals(status.contains("1"), true);
				System.out.println("Employe name added successfully");
			}else if (value.equalsIgnoreCase("No")) {
				System.out.println("Employee name not added thank you");
			}
		}
		db.closeDataBaseConnection();
		
	
	}
}
