package Com.vtiger.practice;

import org.testng.annotations.Test;

import Com.vtiger.pomRepository.CreateNewProductPage;
import Com.vtiger.pomRepository.ProductInformationPage;
import Com.vtiger.pomRepository.ProductPage;
import Ctom.SDET34L1GenericUtility.BaseClass;
import Ctom.SDET34L1GenericUtility.MsExcel;

public class CreateProductTest extends BaseClass {
	CreateNewProductPage createProduct;
	ProductPage productPageDetails;
	ProductInformationPage productInfo;
	@Test
	
	public void createproductpropertiesTest() throws InterruptedException {
		String excel = MsExcel.getDatafromExcel("product", 1, 1);
    homepage.productClick();
    createProduct=new CreateNewProductPage(driver);
    createProduct.clickOnProductContact();
    productPageDetails=new ProductPage(driver);
    productPageDetails.enterProductNameTxtName(excel);
    productPageDetails.saveProduct();
    productInfo=new ProductInformationPage(driver);
    jutil.assertionThroughifCondition(productInfo.getProductName(), excel,"Product");
 	}
}
	



































//public static void main(String[] args) throws IOException, InterruptedException
//{
//	JavaUtility jutil = new JavaUtility();
//	WebDriver driver=null;
//	FileUtilities.openPropertyFile(IconstantPath.PROPERTYFILEPATH);
//	MsExcel.openExcel(IconstantPath.EXCELPATH);
//	String url = FileUtilities.getDataFromPropertyFile("url");
//	String timeout = FileUtilities.getDataFromPropertyFile("timeout");
//	 String userName = FileUtilities.getDataFromPropertyFile("username");
//	 String password = FileUtilities.getDataFromPropertyFile("password");
//        String browser = FileUtilities.getDataFromPropertyFile("browser");
//	
//
//        JavaUtility.stringTOLong(timeout);
//		long longTimeOut=Long.parseLong(timeout);
//	
//		
//		int ran = jutil.getRandomNumber(2000);
//		
//String excel = MsExcel.getDatafromExcel("product", 1, 1)+ran;
//
//switch (browser) {
//case "chrome":
//	WebDriverManager.chromedriver().setup();
//	driver=new ChromeDriver();
//	break;
//	
//case "firefox":
//	WebDriverManager.firefoxdriver().setup();
//	driver=new FirefoxDriver();
//	break;
//default: {
//	System.out.println("please specifiy the browser");
//	WebDriverManager.firefoxdriver().setup();
//	driver=new FirefoxDriver();
//}		
//}
//WebDriverUtility.navigateApp(url, driver);
//WebDriverUtility.browserSetting(longTimeOut, driver);
//LoginPage loginpage=new LoginPage(driver);
//HomePage homepage=new HomePage(driver);
//loginpage.loginToApp(userName, password);
	
	
