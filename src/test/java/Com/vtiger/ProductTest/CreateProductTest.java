package Com.vtiger.ProductTest;

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
	@Test(groups={"sanity","regreesion"})
	
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
	

































