package org.zolando.practies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDataBase {
	// for DQL statements
	public static void main(String[] args) throws SQLException {
		// step 1 --->create object for driver
		Driver dbdrive = new Driver();

		// step 2---> register driver instance to the jdbc
		DriverManager.registerDriver(dbdrive);

		// step 3--->get/establish the database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss", "root", "root");

		try {
			// step 4---> create the statement
			Statement statement = connection.createStatement();

			// step 5---> execute the query
			ResultSet result = statement.executeQuery("select phone_number from sdet40 where emp_name='prem'");

			System.out.println(result);
			// step 6---> verify or iterate or fetch the data
			while (result.next()) {
				System.out.println(result.getString("phone_number"));
			}
		} finally {
			// step 7---> close the database connection
			connection.close();
		}

	}

}
