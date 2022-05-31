package Ctom.SDET34L1GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Com.vtiger.pomRepository.HomePage;
import Com.vtiger.pomRepository.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
public static WebDriver staticdriver;
/**
 * this class contains all the common testscript
 * 
 */
	public JavaUtility jutil;
	public String userName;
	public String password;
	public long longTimeOut;
	public int randomNumber;
	public WebDriver driver;
	 public HomePage homepage;
	 public LoginPage loginpage;
	
	 
	 /**
	  * this before suit is used for open the excel and property file and also get the database connection
	  * @throws IOException
	  */
	
	@BeforeSuite(groups="BaseClass")
		
		public void beforesuitTest()  throws IOException {
		//open database if it is required
		FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		MsExcel.openExcel(IconstantPath.EXCELPATH);
	}
	
	/**
	 * this method is used to fetch the data from the property file, launch thhe browser and navigate the application
	 */
	 @Parameters("browser")
	@BeforeClass(groups="BaseClass")
	public  void beforeClassTest(String browser)
	{
	 jutil = new JavaUtility();
	String url = FileUtilities.getDataFromPropertyFile("url");
	String timeout = FileUtilities.getDataFromPropertyFile("timeout");
	userName = FileUtilities.getDataFromPropertyFile("username");
	//userName=System.getProperty("USERNAME");
	password = FileUtilities.getDataFromPropertyFile("password");
	//password=System.getProperty("PASSWORD");
   // String browser = FileUtilities.getDataFromPropertyFile("browser");
	longTimeOut=JavaUtility.stringTOLong(timeout);
	randomNumber=jutil.getRandomNumber(2000);
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
		default:
			System.out.println("please specify the browser");
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
	}
	staticdriver=driver;
	
	WebDriverUtility.navigateApp(url, driver);
	WebDriverUtility.browserSetting(longTimeOut, driver);
	 loginpage=new  LoginPage(driver);
	 homepage=new HomePage(driver);
}
	/**
	 * this method is used to login to application
	 */
	@BeforeMethod(groups="BaseClass")
	public void beforeMethod1Test() {
		loginpage.loginToApp(userName, password);
	}
	/**
	 * this method is used to logout from the application
	 */
	@AfterMethod(groups="BaseClass")
	public void afterMethod1Test() {
		homepage.signout(driver);
	}
	/**
	 * this method is used to close the browser
	 */
	@AfterClass(groups="BaseClass")
	public  void afterClassTest() {
		WebDriverUtility.quitbrowser(driver);
	}
	/**
	 * this method is used to close the excel and property file and database connection
	 */
	@AfterSuite(groups="BaseClass")
	public void aftersuitTest() {
		MsExcel.closeExcel();
	}
	}
