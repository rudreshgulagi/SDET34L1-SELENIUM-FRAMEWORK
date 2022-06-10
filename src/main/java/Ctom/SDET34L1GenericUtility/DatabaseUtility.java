package Ctom.SDET34L1GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

/**
 *This classcontains all common action related to database 
 * @author rudresh
 *
 */
public class DatabaseUtility {
	
static Connection connection;
static  Statement statement;	
 /**
  * This method is used to open the database connection and initialize the connection,statement
  * @param dburl
  * @param dbUserName
  * @param dbPassword
 * @throws SQLException 
  */


public static void openDBConnection(String dburl,String dbUserName,String dbPassword) throws SQLException {
	Driver d=new Driver();
	DriverManager.registerDriver(d);
	connection=DriverManager.getConnection(dburl,dbUserName,dbPassword);
	statement=connection.createStatement();
	
	
}
/**

 * This method is used to fetch the data from database/to do the DQL actionson database
 * @param query
 * @param columnName
 * @return
 * @throws SQLException 
 */
public static ArrayList<String>getDataFromDataBase(String query,String columnName) throws SQLException{
	ArrayList<String> list=new ArrayList<>();
	ResultSet result=statement.executeQuery(query);
	while(result.next())
	{
		list.add(result.getString(columnName));
	}
	return list;
}
/**
 * This method is used to validate the data wheather it is presentin database or not
 * @param query1
 * @param columnName
 * @param expectedData
 * @return
 * @throws SQLException 
 */
	public static boolean validateDataInDataBase(String query,String columnName,String expectedData) throws SQLException {
		ArrayList<String> list=getDataFromDataBase(query,columnName);
		boolean flag=false;
		for(String actualData:list)
		{
			if(actualData.equalsIgnoreCase(expectedData)) {
				flag=true;
				break;
			}
		}
	return flag;
	}
	/**
	 * This method is used to store/modify/insert/delete the data in database/to do the DMLand DDL actions on database
	 * @param query
	 * @throws SQLException
	 */
	public static void setDataInDataBase(String query) throws SQLException {
		 int result = statement.executeUpdate(query);
		 if(result>=1) {
			 System.out.println("Data entered/modified successfully"); 
		 }
	}
public static void closeDBConnection() {
	try {
		connection.close();
	}catch(SQLException e) {
		e.printStackTrace();
		System.out.println(e.getMessage());
		System.out.println("while closing the Database connection we got exception");
	}
  }
}



