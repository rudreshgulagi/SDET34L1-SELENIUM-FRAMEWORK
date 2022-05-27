package Com.vtiger.organizationTest;

import org.testng.annotations.Test;

import Com.vtiger.pomRepository.CreateNewOrganizationPage;
import Com.vtiger.pomRepository.OrganizationInformationPage;
import Com.vtiger.pomRepository.OrganizationPage;
import Ctom.SDET34L1GenericUtility.BaseClass;
import Ctom.SDET34L1GenericUtility.MsExcel;

public class CreateOrganizationTest extends BaseClass{
	
	String organizationname;
	CreateNewOrganizationPage createNewOrganization;
	OrganizationPage organizationPage;
	 OrganizationInformationPage  organizationInfoPage;

	@Test(groups={"sanity","regreesion"})
	public void CreateOrganization() {
		
  organizationname = MsExcel.getDatafromExcel("Organization", 2, 1)+randomNumber;
			
  homepage.organizationClick();
  createNewOrganization=new CreateNewOrganizationPage(driver);
  createNewOrganization.clickOnCreateOrganization();
  organizationPage=new OrganizationPage(driver);
  organizationPage.enterOrganizationNameTxtName(organizationname);		
  organizationPage.saveOrganization();
  organizationInfoPage=new OrganizationInformationPage(driver);	
  jutil.assertionThroughifCondition( organizationInfoPage.getOrganizationName(), organizationname,"Organization");
	}
}