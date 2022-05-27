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

public class CreateContactWithquickCreateContactsTestCase59 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
	{
		JavaUtility util = new JavaUtility();
		WebDriver driver=null;
		FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		 MsExcel.openExcel(IconstantPath.EXCELPATH);
		String Excel = MsExcel.getDatafromExcel("Contacts", 20, 1);
		String Excel1 = MsExcel.getDatafromExcel("Contacts", 19, 1);
		
		String url = FileUtilities.getDataFromPropertyFile("url");
		String timeout = FileUtilities.getDataFromPropertyFile("timeout");
		 String userName = FileUtilities.getDataFromPropertyFile("username");
		 String password = FileUtilities.getDataFromPropertyFile("password");
	      //  String browser =FileUtilities.getDataFromPropertyFile("browser");
	        {
	              util.printstatement(url);
	              util.printstatement(timeout);
	              util.printstatement(userName);
	              util.printstatement(password);
	        }
		
	        WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		long longTimeOut = util.stringTOLong(timeout);
		int ran = util.getRandomNumber(1000);

		 WebDriverUtility.navigateApp(url, driver);
		 WebDriverUtility.browserSetting(longTimeOut, driver);
		
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
	    driver.findElement(By.xpath("//select[@id='qccombo']")).click();
		driver.findElement(By.xpath("//option[.='Quick Create...']")).click();
	    Thread.sleep(2000);
		 WebElement ele = driver.findElement(By.xpath("//*[@id='qccombo']"));
		   Select s1=new Select(ele);
			s1.selectByVisibleText(Excel);
		 driver.findElement(By.xpath("//*[@id=\"qcform\"]/form/table/tbody/tr/td/table[2]/tbody/tr/td/table[1]/tbody/tr[1]/td[4]/input")).sendKeys(Excel1);
         driver.findElement(By.xpath("//*[@id=\"qcform\"]/form/table/tbody/tr/td/table[2]/tbody/tr/td/table[2]/tbody/tr/td[1]/input")).click();
         WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
         WebDriverUtility.mouseHoverOntheElement(ele3, driver);
         driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
}
