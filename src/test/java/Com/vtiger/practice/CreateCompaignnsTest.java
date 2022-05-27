package Com.vtiger.practice;
import org.testng.annotations.Test;

import Com.vtiger.pomRepository.CampaignPage;
import Com.vtiger.pomRepository.CreateNewCampaignPage;
import Ctom.SDET34L1GenericUtility.BaseClass;
import Ctom.SDET34L1GenericUtility.MsExcel;

public class CreateCompaignnsTest extends BaseClass
{
	@Test
	public void createCompaignnsTest() 
	{
		homepage.campaignClick(driver);
		homepage.campaignClick(driver);
		String excel = MsExcel.getDatafromExcel("campaign", 2, 1);
		CampaignPage campaign=new CampaignPage(driver);
		campaign.CreateCampaign();
		CreateNewCampaignPage campaignpage=new CreateNewCampaignPage(driver);
		campaignpage.CreateNewCampaign(excel);
		campaignpage.SaveNewCampaign();	
}
}


























//public static void createcompaignTest() throws Throwable {
//public static void main(String[] args) throws IOException {
//	JavaUtility jutil = new JavaUtility();
//	MsExcel.openExcel(IconstantPath.EXCELPATH);
//	String excel = MsExcel.getDatafromExcel("campaign", 2, 1);
//	
//	FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
//	String url = FileUtilities.getDataFromPropertyFile("url");
//	String timeout = FileUtilities.getDataFromPropertyFile("timeout");
//	 String userName = FileUtilities.getDataFromPropertyFile("username");
//	 String password = FileUtilities.getDataFromPropertyFile("password");
//        String browser = FileUtilities.getDataFromPropertyFile("browser");
//        {
//        	jutil.printstatement(url);
//        	jutil.printstatement(timeout);
//        	jutil.printstatement(userName);
//        	jutil.printstatement(password);
//        }
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




//Actions act=new Actions(driver);
	//	act.moveToElement(d2).perform();
//driver.findElement(By.xpath("//a[@name='Campaigns']")).click();
//WebElement d2 = driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']"));
		//WebDriverUtility.mouseHoverOntheElement(d2, driver);
//driver.findElement(By.xpath("//img[@src=\'themes/softed/images/btnL3Add.gif\']")).click();
//driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys("SDETYYS");
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//WebElement compain = driver.findElement(By.xpath("//td[@id='mouseArea_Campaign Name']"));
/*WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
WebDriverUtility.mouseHoverOntheElement(ele, driver);
WebElement ele1 = driver.findElement(By.xpath("//a[.='Sign Out']"));
WebDriverUtility.quitbrowser(driver);*/
/* Actions act1=new Actions(driver);
act.moveToElement(ele1).build().perform();
ele1.click();*/