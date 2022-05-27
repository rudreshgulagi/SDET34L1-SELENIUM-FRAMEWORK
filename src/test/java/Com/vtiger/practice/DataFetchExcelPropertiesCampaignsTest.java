package Com.vtiger.practice;

import java.io.IOException;

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

public class DataFetchExcelPropertiesCampaignsTest {
	
	public static void main(String[] args) throws IOException {
		JavaUtility uti = new JavaUtility();
		WebDriver driver=null;
		FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
		MsExcel.openExcel(IconstantPath.PROPERTYFILEPATH);
		
		String url = FileUtilities.getDataFromPropertyFile("url");
		String timeout =  FileUtilities.getDataFromPropertyFile("timeout");
		String username =  FileUtilities.getDataFromPropertyFile("username");
		String password =  FileUtilities.getDataFromPropertyFile("password");
		String browser =  FileUtilities.getDataFromPropertyFile("browser");
	
		long longTimeOut = uti.stringTOLong(timeout);
		int randomNumber = uti.getRandomNumber(1000);
		
		String compaignname = MsExcel.getDatafromExcel("campaign", 1, 2)+randomNumber;
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		WebDriverUtility.navigateApp(url, driver);
		WebDriverUtility.browserSetting(longTimeOut, driver);
		/*driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(longTimeOut,TimeUnit.SECONDS);*/
		
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		 driver.findElement(By.name("user_password")).sendKeys(password);
		 driver.findElement(By.id("submitButton")).click();
		 
		 
		 WebElement more = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		WebDriverUtility.mouseHoverOntheElement(more, driver);	
		 /*Actions act= new Actions(driver);
			act.moveToElement(more).perform();*/
		
			driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
			driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
			driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("campaignname");
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			WebElement campain = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']"));
			
			
			if(campain.getText().equalsIgnoreCase(compaignname));
			{
				System.out.println("campain name is created");
				System.out.println("TC pass");
				
				 WebElement atoradminist = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				 WebDriverUtility.mouseHoverOntheElement(atoradminist, driver);
				 driver.findElement(By.xpath("//a[.='Sign Out']"));
				WebDriverUtility.quitbrowser(driver); 
	}

}
}