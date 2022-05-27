package Com.vtiger.compaigns.Test;
import org.testng.annotations.Test;

import Com.vtiger.pomRepository.CampaignPage;
import Com.vtiger.pomRepository.CreateNewCampaignPage;
import Ctom.SDET34L1GenericUtility.BaseClass;
import Ctom.SDET34L1GenericUtility.MsExcel;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class CreateCompaignsTest extends BaseClass
{
	@Test(groups="sanity",description="testing:-CreateCompaigns")
	@Description("Description:-CreateCompaignsTest")
	@Epic("Epic:-CreateCompaignsTest")
	@Story("story:-CreateCompaignsTest")
	@Severity(SeverityLevel.BLOCKER)
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


























