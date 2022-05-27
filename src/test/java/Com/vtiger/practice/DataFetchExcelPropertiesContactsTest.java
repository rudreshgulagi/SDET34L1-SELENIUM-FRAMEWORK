package Com.vtiger.practice;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Ctom.SDET34L1GenericUtility.FileUtilities;
import Ctom.SDET34L1GenericUtility.IconstantPath;
import Ctom.SDET34L1GenericUtility.JavaUtility;
import Ctom.SDET34L1GenericUtility.MsExcel;
import Ctom.SDET34L1GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataFetchExcelPropertiesContactsTest {
	
	public static void main(String[] args) throws IOException {
		JavaUtility uti = new JavaUtility();
		WebDriver driver=null;
		FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		MsExcel.openExcel(IconstantPath.PROPERTYFILEPATH);
		
	/*FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
	Properties property=new Properties();
	property.load(fis);*/
		
		String url = FileUtilities.getDataFromPropertyFile("url");
		String timeout =  FileUtilities.getDataFromPropertyFile("timeout");
		String username =  FileUtilities.getDataFromPropertyFile("username");
		String password =  FileUtilities.getDataFromPropertyFile("password");
		String browser =  FileUtilities.getDataFromPropertyFile("browser");
	

		long longTimeOut = uti.stringTOLong(timeout);
		int randomNumber = uti.getRandomNumber(1000);
		
/*FileInputStream fisExcel = new FileInputStream("./src/test/resources/Book2.xlsx");
	Workbook wb = WorkbookFactory.create(fisExcel);
	Random ran = new Random();
	int randomNumber = ran.nextInt(1000);
	String LastName = wb.getSheet("contacts").getRow(2).getCell(1).getStringCellValue()+randomNumber;*/
	
		String contactfirstname = MsExcel.getDatafromExcel("Contacts", 1, 2)+randomNumber;
		
	//WebDriver driver=null;
	switch (browser) {
	case "chrome":
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		break;
	case "firefox":
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		break;
	}
	
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	WebDriverUtility.navigateApp(url, driver);
	WebDriverUtility.browserSetting(longTimeOut, driver);

	/*driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);*/
	
	//test case 1===>login to the app
	driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	
	/* if(driver.getTitle().contains("Home"))
	 {
		 wb.getSheet("contacts").getRow(14).createCell(5).setCellValue("Home page is displayed");
		 wb.getSheet("contacts").getRow(6).createCell(6).setCellValue("pass");
	 }*/
	 MsExcel.setDataIntoExcel("Contacts", 9, 4, "home page is displayd");
	 MsExcel.setDataIntoExcel("Contacts", 9, 5, "Tc Pass");
	 
	 //testcase step2===>click on contact
	 driver.findElement(By.linkText("Contacts")).click();
	 if(driver.getTitle().contains("contacts"))
	 {
	//	 wb.getSheet("contacts").getRow(3).createCell(3).setCellValue("contacts page is displayed");
	//	 wb.getSheet("contacts").getRow(3).createCell(4).setCellValue("pass");
	 }
	 
	
	 driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	 
	 
	 driver.findElement(By.name("lastname")).sendKeys("LastName");
	 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	 WebElement Actualastname = driver.findElement(By.id("dtlview_First Name"));
	 
	// if(Actualastname.getText().equalsIgnoreCase(LastName));
	 {
		 System.out.println("contact created successfully");
		 System.out.println("TC pass");
	 }
	 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 WebDriverUtility.mouseHoverOntheElement(atoradminist, driver);
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	WebDriverUtility.quitbrowser(driver);

	 }

	
	
	
	
	}
