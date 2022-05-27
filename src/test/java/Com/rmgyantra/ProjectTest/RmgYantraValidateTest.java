package Com.rmgyantra.ProjectTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class RmgYantraValidateTest {
	public static void main(String[] args) throws SQLException
	{
		Connection connection = null;
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			 Statement statement = connection.createStatement();
			int result = statement.executeUpdate("insert into project values('TY_project_985', 'ru', '27/04/2022, 'Database', 'on going', 4)");
					if(result==1)
					{
						System.out.println("Data inserted in the database successfully");
					}
		}
		finally
		{
	    connection.close();
		}
	}
	
}


