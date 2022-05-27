package Com.vtiger.TC;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Ctom.SDET34L1GenericUtility.FileUtilities;
import Ctom.SDET34L1GenericUtility.IconstantPath;
import Ctom.SDET34L1GenericUtility.JavaUtility;
import Ctom.SDET34L1GenericUtility.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoAndFindDuplicateSelectContactsAndTryToMergeContactsTestCase56 {

	public static void main(String[] args) throws IOException, InterruptedException {
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
	        WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		long longTimeOut = util.stringTOLong(timeout);
		int ran = util.getRandomNumber(1000);

		 WebDriverUtility.navigateApp(url, driver);
		 WebDriverUtility.browserSetting(longTimeOut, driver);
		
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
		driver.findElement(By.xpath("//img[@src='themes/images/findduplicates.gif']")).click();
		driver.findElement(By.xpath("//option[@value='67']")).click();
		driver.findElement(By.xpath("//input[@onclick='addColumn()']")).click();
		driver.findElement(By.xpath("//option[@value='70']")).click();
		driver.findElement(By.xpath("//input[@onclick='addColumn()']")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//input[@name='group2']")).click();
		driver.findElement(By.xpath("(//input[@id='group2'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='merge']")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		Thread.sleep(3000);
		 WebElement ele1 = driver.findElement(By.xpath("//a[.='Sign Out']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(ele1).build().perform();
		 ele1.click();
}
}
