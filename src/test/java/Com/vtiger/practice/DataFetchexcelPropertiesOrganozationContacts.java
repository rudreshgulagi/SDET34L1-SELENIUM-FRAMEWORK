package Com.vtiger.practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Ctom.SDET34L1GenericUtility.FileUtilities;
import Ctom.SDET34L1GenericUtility.IconstantPath;
import Ctom.SDET34L1GenericUtility.JavaUtility;
import Ctom.SDET34L1GenericUtility.MsExcel;
import Ctom.SDET34L1GenericUtility.WebDriverUtility;

public class DataFetchexcelPropertiesOrganozationContacts {
	
	public static void main(String[] args) throws IOException {

		JavaUtility util = new JavaUtility();
		WebDriver driver=null;
		FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
	//FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
	//Properties property=new Properties();
	//property.load(fis);
	String url =  FileUtilities.getDataFromPropertyFile("url");
	String timeout =  FileUtilities.getDataFromPropertyFile("timeout");
	String username =  FileUtilities.getDataFromPropertyFile("username");
	String password =  FileUtilities.getDataFromPropertyFile("password");
	String browser =  FileUtilities.getDataFromPropertyFile("browser");
	
	long longTimeOut = util.stringTOLong(timeout);
	int ran = util.getRandomNumber(1000);

	//long longTimeOut=Long.parseLong(timeout);
	//WebDriver driver=null;
	
	FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
	MsExcel.openExcel(IconstantPath.PROPERTYFILEPATH);
	
	String Organization = MsExcel.getDatafromExcel("Organization", 2, 1)+ran;

	//FileInputStream fis1=new FileInputStream("./src/test/resources/Book2.xlsx");
	//Workbook wb = WorkbookFactory.create(fis1);
	//Sheet sh = wb.getSheet("Organization");
	//Row row = sh.getRow(2);
	//Cell cell = row.getCell(1);
	//String contactname = cell.getStringCellValue();		
	//wb.close();
	
	WebDriverUtility.navigateApp(url, driver);
	WebDriverUtility.browserSetting(longTimeOut, driver);
	//WebDriverManager.chromedriver().setup();
	//driver=new ChromeDriver();
	//driver.get(url);
	//driver.manage().window().maximize();
	//driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);
	
	
	driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 
	 
	 driver.findElement(By.xpath("//a[.='Contacts']")).click();
	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	
	 
	 driver.findElement(By.name("lastname")).sendKeys("contactname");
	  driver.findElement(By.xpath("//img[@alt='Select']")).click();
	 
	  String orgaoname="rudhresh12345645";
	 
	  String contactorganization = driver.getWindowHandle();
	  driver.switchTo().window(contactorganization);
	  driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(orgaoname);
	  driver.findElement(By.xpath("//input[@name='search']")).click();
	  driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
	  
	  WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	  WebDriverUtility.mouseHoverOntheElement(atoradminist, driver);
	  /* Actions act=new Actions(driver);
		 act.moveToElement(atoradminist).build().perform();*/
		 driver.findElement(By.xpath("//a[.='Sign Out']"));
		 driver.quit(); 
}
}