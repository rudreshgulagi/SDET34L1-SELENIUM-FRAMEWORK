package Com.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Ctom.SDET34L1GenericUtility.FileUtilities;
import Ctom.SDET34L1GenericUtility.IconstantPath;
import Ctom.SDET34L1GenericUtility.JavaUtility;
import Ctom.SDET34L1GenericUtility.MsExcel;
import Ctom.SDET34L1GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectDocument {
public static void main(String[] args) throws Throwable {
	JavaUtility uti = new JavaUtility();
	WebDriver driver=null;
	FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
	MsExcel.openExcel(IconstantPath.EXCELPATH);
	//FileInputStream fis=new FileInputStream("./src/test/resources/CommonData.Properties");
	//Properties property=new Properties();
	//property.load(fis);
	String url = FileUtilities.getDataFromPropertyFile("url");
	String timeout = FileUtilities.getDataFromPropertyFile("timeout");
	String username =FileUtilities.getDataFromPropertyFile("username");
	String password = FileUtilities.getDataFromPropertyFile("password");
	String browser =FileUtilities.getDataFromPropertyFile("browser");
System.out.println(timeout);
	long longTimeOut=Long.parseLong(timeout);
	int randomNumber = uti.getRandomNumber(1000);
	
	String document = MsExcel.getDatafromExcel("document", 1, 0)+randomNumber;
	String documentpath = MsExcel.getDatafromExcel("document", 1, 1);
	String documentdiscription = MsExcel.getDatafromExcel("document", 1, 2)+randomNumber;

	
	//Workbook wb = WorkbookFactory.create(fis2);
	//int ran = jutil.getRandomNumber(2000);
	//Random ran = new Random();
	//int randomNumber=ran.nextInt();
	//String DocumentTitle = wb.getSheet("document").getRow(0).getCell(0).getStringCellValue();
	//String DocumentPath = wb.getSheet("document").getRow(1).getCell(1).getStringCellValue();
	//String DocumentDescription = wb.getSheet("document").getRow(1).getCell(2).getStringCellValue();

	//WebDriver driver=null;
	 WebDriverManager.chromedriver().setup();
	 driver=new ChromeDriver();
	 WebDriverUtility.navigateApp(url, driver);
	 WebDriverUtility.browserSetting(longTimeOut, driver);
	// driver.get(url);
	// driver.manage().window().maximize();
	// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.name("user_name")).sendKeys(username);
	 driver.findElement(By.name("user_password")).sendKeys(password);
	 driver.findElement(By.id("submitButton")).click();
	 
	 driver.findElement(By.xpath("//a[@href='index.php?module=Documents&action=index']")).click();
	 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
	 driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(documentdiscription);
	 
	 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']")));
	 driver.findElement(By.xpath("//body[@class='cke_show_borders']")).sendKeys(documentdiscription,Keys.CONTROL+"a");
	 driver.switchTo().defaultContent();
	 driver.findElement(By.xpath("//a[@id='cke_5']")).click();
	 driver.findElement(By.xpath("//a[@id='cke_6']")).click();
	 
	 
	driver.findElement(By.id("filename_I__")).sendKeys(documentpath);
	//ele.sendKeys("C:/Users/rudresh/Desktop/RUDRESH.CV.pdf");
	 driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[2]")).click();
	 WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	 WebDriverUtility.mouseHoverOntheElement(ele, driver);
	 driver.findElement(By.xpath("//a[.='Sign Out']"));
	
}
}