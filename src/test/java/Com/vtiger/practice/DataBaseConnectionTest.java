package Com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DataBaseConnectionTest
    {
	public static void main(String[] args) throws SQLException
	  {
		Connection connection = null;
		try
		{//step 1 create object for implementation class
		Driver driver=new Driver();
		//step2 register the driver with jdbc
		DriverManager.registerDriver(driver);
		//step3 Estrablish the database connection
		 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		//step 4 create  statement
		Statement statement = connection.createStatement();
		//step5 execute query
		ResultSet result = statement.executeQuery("select *from sdet34;");
		// step6 validate(based on test case)
	while(result.next())
	{
		System.out.println(result.getString("ename"+" "+result.getString("job")));
		
	}
	}
	finally
	{
	 System.out.println("testing purpose1");
	
	//step7 close the connection(mandatory)
	connection.close();
	}
}
     
}
