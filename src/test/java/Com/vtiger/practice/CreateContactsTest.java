
package Com.vtiger.practice;

import org.testng.annotations.Test;

import Com.vtiger.pomRepository.ContactValidationPage;
import Com.vtiger.pomRepository.ContactsPage;
import Com.vtiger.pomRepository.CreateContactPage;
import Ctom.SDET34L1GenericUtility.BaseClass;
import Ctom.SDET34L1GenericUtility.MsExcel;

public class CreateContactsTest extends BaseClass {
	@Test
	 public  void createcontactTest() 
	{ 
	  String excel1 = MsExcel.getDatafromExcel("Contacts", 24, 2);
		    homepage.contactClick();
			ContactsPage contactsPage=new ContactsPage(driver);
			contactsPage.createContact();
			CreateContactPage contactpage=new CreateContactPage(driver);
			contactpage.lastName(excel1);
			contactpage.saveCreateContact();
			ContactValidationPage validation=new ContactValidationPage(driver);
			jutil.assertionThroughifCondition(validation.contactvalidation(), excel1, "Element is Displayed");
	 } 
	}


















//public static void main(String[] args) throws IOException {
//JavaUtility jutil = new JavaUtility();
//	MsExcel.openExcel(IconstantPath.EXCELPATH);
//	String excel1 = MsExcel.getDatafromExcel("Contacts", 24, 2);
//	FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
//	String url = FileUtilities.getDataFromPropertyFile("url");
//	String timeout = FileUtilities.getDataFromPropertyFile("timeout");
//	 String userName = FileUtilities.getDataFromPropertyFile("username");
//	 String password = FileUtilities.getDataFromPropertyFile("password");
//       String browser = FileUtilities.getDataFromPropertyFile("browser");
//       {
//       	jutil.printstatement(url);
//       	jutil.printstatement(timeout);
//       	jutil.printstatement(userName);
//       	jutil.printstatement(password);
//       }
//	JavaUtility.stringTOLong(timeout);
//	long longTimeOut=Long.parseLong(timeout);
//	WebDriver driver=null;
//	
//	int ran = jutil.getRandomNumber(2000);
//	
//	switch (browser) {
//	case "chrome":
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver();
//		break;
//	case "firefox":
//		WebDriverManager.firefoxdriver().setup();
//		driver=new FirefoxDriver();
//	}
//	WebDriverUtility.navigateApp(url, driver);
//	WebDriverUtility.browserSetting(longTimeOut, driver);
//	LoginPage loginpage=new  LoginPage(driver);
//	HomePage homepage=new HomePage(driver);
//	loginpage.loginToApp(userName, password);

		/* WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.get("http://localhost:8888");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
	 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
	 driver.findElement(By.xpath("//input[@type='submit']")).click();
	 driver.findElement(By.xpath("//a[.='Contacts']")).click();*/
//driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing']")).click();
		/* driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Rudresh95");
		 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		 WebElement ele = driver.findElement(By.xpath("//span[.='Rudresh95']"));
		 boolean p = ele.isDisplayed();
		 if(p)
		 {
			 System.out.println("Element is display");
		 }
		 else
		 {
			 System.out.println("Element is not display");
		 }
		 driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		 WebElement ele1 = driver.findElement(By.xpath("//a[.='Sign Out']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(ele1).build().perform();
		 ele1.click();*/
	

