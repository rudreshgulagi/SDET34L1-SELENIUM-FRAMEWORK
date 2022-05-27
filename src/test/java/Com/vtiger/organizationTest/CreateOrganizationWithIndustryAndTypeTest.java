package Com.vtiger.organizationTest;

import org.testng.annotations.Test;

import Com.vtiger.pomRepository.CreateOrganizationPage;
import Com.vtiger.pomRepository.OrganizationInformationPage;
import Ctom.SDET34L1GenericUtility.BaseClass;
import Ctom.SDET34L1GenericUtility.MsExcel;

public class CreateOrganizationWithIndustryAndTypeTest extends BaseClass {

	@Test(groups={"sanity","regreesion"})
	
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


















