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

public class GoToContactAndCreateaFilterWithValidinformationContactsTestCase58 {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException
	{
		JavaUtility util = new JavaUtility();
		WebDriver driver=null;
		FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		 MsExcel.openExcel(IconstantPath.EXCELPATH);
		 String Excel = MsExcel.getDatafromExcel("Contacts", 15, 1);
		 String Excel2 = MsExcel.getDatafromExcel("Contacts", 17, 1);
		 String Excel3 = MsExcel.getDatafromExcel("Contacts", 18, 1);
		
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
			 driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=CustomView&parenttab=Marketing']")).click();
			 driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys("Excel");
			 driver.findElement(By.xpath("//input[@type='checkbox']/ancestor::tr[1]//td[5]/input")).click();
			 driver.findElement(By.xpath("//b[.='Standard Filters']")).click();
			 WebElement ele = driver.findElement(By.xpath("//select[@name='stdDateFilterField']"));
			    Select s1=new Select(ele);
				  s1.selectByVisibleText(Excel);
				  Thread.sleep(2000);
			/*  WebElement ele1 = driver.findElement(By.xpath("//select[@name='stdDateFilter']"));
				    Select s2=new Select(ele1);
					  s2.selectByVisibleText(Excel1); */
			 driver.findElement(By.xpath("//input[@name='startdate']")).sendKeys(Excel2);
			 driver.findElement(By.xpath("//input[@name='enddate']")).sendKeys(Excel3);
			 WebElement ele3 = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			 WebDriverUtility.mouseHoverOntheElement(ele3, driver);
	    	 driver.findElement(By.xpath("//a[.='Sign Out']")).click();
}
}
