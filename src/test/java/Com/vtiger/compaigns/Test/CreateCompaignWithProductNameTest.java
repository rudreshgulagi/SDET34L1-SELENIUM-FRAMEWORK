package Com.vtiger.compaigns.Test;

import org.testng.annotations.Test;

import Com.vtiger.pomRepository.CampaignInformationPage;
import Com.vtiger.pomRepository.CampaignPage;
import Com.vtiger.pomRepository.ContactChildBrowserPage;
import Com.vtiger.pomRepository.CreateNewCampaignPage;
import Com.vtiger.pomRepository.CreateNewProductPage;
import Com.vtiger.pomRepository.ProductInformationPage;
import Com.vtiger.pomRepository.ProductPage;
import Ctom.SDET34L1GenericUtility.BaseClass;
import Ctom.SDET34L1GenericUtility.MsExcel;
import Ctom.SDET34L1GenericUtility.WebDriverUtility;

public class CreateCompaignWithProductNameTest extends BaseClass  {
		String campaignname;
		CampaignPage campaignPage;
		CreateNewCampaignPage createnewcampaignpage;
		CampaignInformationPage campaigninformation;
		String productnname;
		ProductPage productPage;
		CreateNewProductPage createNewProduct;
		ProductInformationPage productInfoPage;
		ContactChildBrowserPage campaignProductChildBrowser;	
		@Test(groups={"sanity","regreesion"})
		
	     public void createCampaignTest() {
		 campaignname = MsExcel.getDatafromExcel("campaigns", 2, 1)+randomNumber;
		 productnname = MsExcel.getDatafromExcel("product", 1, 0)+randomNumber;
		 campaignPage =new CampaignPage(driver);
		 createnewcampaignpage=new CreateNewCampaignPage(driver);
		 campaigninformation=new CampaignInformationPage(driver);
		 productPage=new ProductPage(driver);
		 createNewProduct=new CreateNewProductPage(driver);
		 productInfoPage=new ProductInformationPage(driver);
		 campaignProductChildBrowser=new ContactChildBrowserPage(driver);		 
		 homepage.productClick	();
		 createNewProduct.clickOnProductContact();
		 productPage.enterProductNameTxtName(productnname);
		 productPage.saveProduct();
		 homepage.campaignClick(driver);
		 campaignPage.CreateCampaign();
		 createnewcampaignpage.enterCampaignName(campaignname);
		 campaignPage.clickOnProductSelect();
		 WebDriverUtility.switchToWindowBasedOnTitle(driver, productnname);
		 campaignProductChildBrowser.childBrowsetHandels(driver, productnname);
		 WebDriverUtility
		 .switchToWindowBasedOnTitle(driver, "CAMPAIGNS");
		  createnewcampaignpage.SaveNewCampaign();
		  jutil.assertionThroughifCondition(campaigninformation.getCampaignName(), campaignname, "Campaign with Product");
	}	
	}
