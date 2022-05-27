package Com.vtiger.practice;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Ctom.SDET34L1GenericUtility.FileUtilities;
import Ctom.SDET34L1GenericUtility.IconstantPath;
import Ctom.SDET34L1GenericUtility.JavaUtility;
import Ctom.SDET34L1GenericUtility.MsExcel;
import Ctom.SDET34L1GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationsTest {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		JavaUtility uti = new JavaUtility();
		FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		MsExcel.openExcel(IconstantPath.PROPERTYFILEPATH);
		int randomNumber = uti.getRandomNumber(1000);
		String orgname = MsExcel.getDatafromExcel("Organization", 2, 1)+randomNumber;
		
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 driver.get("http://localhost:8888");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
		 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
		 driver.findElement(By.xpath("//input[@type='submit']")).click();
		 driver.findElement(By.xpath("//a[.='Organizations']")).click();
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		 driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 WebElement ele = driver.findElement(By.xpath("//span[.='Rudresh1995']"));
		 boolean p = ele.isDisplayed();
		 
		 if(p)
		 {
			 System.out.println("Element is displayed");
		 }
		 else
		 {
			 System.out.println("Element is not displayed");
		 }
		 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		 WebDriverUtility.mouseHoverOntheElement(atoradminist, driver);
		 driver.findElement(By.xpath("//a[.='Sign Out']"));
		WebDriverUtility.quitbrowser(driver); 
		 }

	}


