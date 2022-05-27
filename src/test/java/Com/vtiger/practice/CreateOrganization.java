package Com.vtiger.practice;

import org.testng.annotations.Test;

import Com.vtiger.pomRepository.CreateOrganizationPage;
import Com.vtiger.pomRepository.OrganizationInformationPage;
import Ctom.SDET34L1GenericUtility.BaseClass;
import Ctom.SDET34L1GenericUtility.MsExcel;

public class CreateOrganization extends BaseClass {

	
	@Test
	
	public void createorganizationTest() {
	
	String excel = MsExcel.getDatafromExcel("Organization", 2, 1);
	String excel1 = MsExcel.getDatafromExcel("Organization", 3, 1);
    String excel2 = MsExcel.getDatafromExcel("Organization", 4, 1);
	homepage.organizationClick();
	CreateOrganizationPage org=new CreateOrganizationPage(driver);
	org.CreateNew();
	OrganizationInformationPage orgpage=new OrganizationInformationPage(driver);
	orgpage.OrgName(excel);
	orgpage.industryDropDown(excel1);
	orgpage.typeDropDown(excel2);
	orgpage.OrganInfo();
	homepage.signout(driver);
  

}
}



















//private static final WebElement Education = null;
//private static final WebElement Analyst = null;
//private static final WebElement Excel1 = null;
//
//public static void main(String[] args) throws Throwable {
//	
//	JavaUtility jutil = new JavaUtility();
//	MsExcel.openExcel(IconstantPath.EXCELPATH);
//	String excel = MsExcel.getDatafromExcel("Organization", 2, 1);
//	String excel1 = MsExcel.getDatafromExcel("Organization", 3, 1);
//	String excel2 = MsExcel.getDatafromExcel("Organization", 4, 1);
//	FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
//	String url = FileUtilities.getDataFromPropertyFile("url");
//	String timeout = FileUtilities.getDataFromPropertyFile("timeout");
//	 String userName = FileUtilities.getDataFromPropertyFile("username");
//	 String password = FileUtilities.getDataFromPropertyFile("password");
//      String browser = FileUtilities.getDataFromPropertyFile("browser");
//      {
//      	jutil.printstatement(url);
//      	jutil.printstatement(timeout);
//      	jutil.printstatement(userName);
//      	jutil.printstatement(password);
//      }
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


















/*JavaUtility jutil1 = new JavaUtility();
WebDriver driver=null;

FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
MsExcel.openExcel(IconstantPath.EXCELPATH);

String url =  FileUtilities.getDataFromPropertyFile("url");
String timeout = FileUtilities.getDataFromPropertyFile("timeout");
String username =  FileUtilities.getDataFromPropertyFile("username");
String password = FileUtilities.getDataFromPropertyFile("password");
String browser =  FileUtilities.getDataFromPropertyFile("browser");

long longTimeOut = jutil1.stringTOLong(timeout);
int randomNumber = jutil1.getRandomNumber(1000);
	
 String organizationname = MsExcel.getDatafromExcel("Organization", 2, 1 )+randomNumber;

WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
//driver.get("http://localhost:8888");
//drive.manage().window().maximize();
// driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
WebDriverUtility.navigateApp(url, driver);
WebDriverUtility.browserSetting(longTimeOut, driver);

 driver.findElement(By.xpath("//input[@type='text']")).sendKeys("admin");
 driver.findElement(By.xpath("//input[@type='password']")).sendKeys("admin");
 driver.findElement(By.xpath("//input[@type='submit']")).click();*/
//driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
	// driver.findElement(By.xpath("(//td[@style='padding-right:0px;padding-left:10px;'])[1]")).click();
	
	// String organizationname = "rudhresh12345645";
/* driver.findElement(By.xpath("(//input[@class='detailedViewTextBox'])[1]")).sendKeys(organizationname);
WebElement ele = driver.findElement(By.xpath("//select[@name='industry']"));
Select s=new Select(ele);
s.selectByValue("Education");*/

/* WebElement ele1 = driver.findElement(By.xpath("//select[@name='accounttype']"));
 Select s1=new Select(ele1);
 s1.selectByValue("Analyst");
 driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]"));*/
// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
