package Com.vtiger.TC;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Ctom.SDET34L1GenericUtility.FileUtilities;
import Ctom.SDET34L1GenericUtility.IconstantPath;
import Ctom.SDET34L1GenericUtility.JavaUtility;
import Ctom.SDET34L1GenericUtility.MsExcel;
import Ctom.SDET34L1GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoAndFindDuplicateSelectContactsByUsingFiltersContactsTestCase57 {
 public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException 
 {
		JavaUtility util = new JavaUtility();
		WebDriver driver=null;
		FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		
		
		String url = FileUtilities.getDataFromPropertyFile("url");
		String timeout = FileUtilities.getDataFromPropertyFile("timeout");
		 String userName = FileUtilities.getDataFromPropertyFile("username");
		 String password = FileUtilities.getDataFromPropertyFile("password");
	        String browser =FileUtilities.getDataFromPropertyFile("browser");
	        {
	              util.printstatement(url);
	              util.printstatement(timeout);
	              util.printstatement(userName);
	              util.printstatement(password);
	        }	
	 
	 MsExcel.openExcel(IconstantPath.EXCELPATH);
	 String Excel = MsExcel.getDatafromExcel("Contacts", 12, 1);
	 String Excel1 = MsExcel.getDatafromExcel("Contacts", 13, 1);
	 WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	long longTimeOut = util.stringTOLong(timeout);
	int ran = util.getRandomNumber(1000);

	 WebDriverUtility.navigateApp(url, driver);
	 WebDriverUtility.browserSetting(longTimeOut, driver);
	
	driver.findElement(By.name("user_name")).sendKeys(userName);
	driver.findElement(By.name("user_password")).sendKeys(password);
	driver.findElement(By.id("submitButton")).click();
		 driver.findElement(By.xpath("//a[.='Contacts']")).click();
         driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Search.gif']")).click();
	     WebElement ele = driver.findElement(By.xpath("//select[@id='viewname']"));
	    Select s1=new Select(ele);
		  s1.selectByVisibleText(Excel);
		  Thread.sleep(2000);
		  s1.selectByVisibleText(Excel1);
		  Thread.sleep(3000);
		 WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 WebDriverUtility.mouseHoverOntheElement(ele3, driver);
			 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
}
}