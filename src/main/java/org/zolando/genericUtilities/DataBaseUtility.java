package org.zolando.genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

/**
 * This class consist of data base reusable methods
 * 
 * @author PREM
 *
 */
public final class DataBaseUtility {
	private Connection connection;

	/**
	 * This method is used to open DataBase Connection
	 * 
	 * @param dbURL
	 * @param userName
	 * @param UserPassword
	 */
	public void openDBConnection(String dbURL, String userName, String UserPassword) {
		try {
			Driver dbDriver = new Driver();
			DriverManager.registerDriver(dbDriver);
			connection = DriverManager.getConnection(dbURL, userName, UserPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get the data from the table
	 * 
	 * @param query
	 * @param whichColum
	 * @return List<String>
	 */
	public List<String> getDataFromDataBase(String query, String whichColum) {
		List<String> list = new ArrayList<String>();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(query);
			while (result.next()) {
				list.add(result.getString(whichColum));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * This method is used to update the data to dataBase
	 * @param updateQuery
	 * @return
	 */
	public String setDataToDataBase(String updateQuery) {
		String status=null;
		try {
			Statement statement = connection.createStatement();
			int b = statement.executeUpdate(updateQuery);
			status=b+"rows are updated";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	/**
	 * This method is used to close the data base connection
	 */
	public void closeDataBaseConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean validateTheData(String query, String whichColumnReq,String expctedResult) {
		List<String> list = getDataFromDataBase(query, whichColumnReq);
		boolean flage = false;
		for (String ActualResult : list) {
			if (ActualResult.equalsIgnoreCase(expctedResult)) {
				flage=true;
				break;
			}
		}
		return flage;
	}
	
}
