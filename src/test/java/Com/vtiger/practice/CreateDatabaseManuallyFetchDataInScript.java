package Com.vtiger.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateDatabaseManuallyFetchDataInScript{
	public static void main(String[] args) throws SQLException
	{
	Driver d = new Driver();
	DriverManager.registerDriver(d);
	 Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vtiger26","root","root");
Statement statement = connection.createStatement();
ResultSet result = statement.executeQuery("select * from vtiger26;");
while(result.next())
{
	String url = result.getString("url");
	String username = result.getString("password");
	String timeout = result.getString("timeout");
	String browserName = result.getString("browserName");
}
long longTimeout = Long.parseLong("timeout");
WebDriver driver=null;


}
	
}
		
	
	 

