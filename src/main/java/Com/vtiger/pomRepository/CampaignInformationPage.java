package Com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {

	@FindBy(id="dtlview_Campaign Name")
	private WebElement CampaignInformation;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Org_Information;
	
	@FindBy(id = "dtlview_Campaign Name")
	private WebElement campaignNameText;
	
	@FindBy(xpath = "//td[@id='mouseArea_Last Name']")
	private WebElement contactNameText;
	
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String CampaignInfo() {
	return CampaignInformation.getText();
	}
	
public String getCampaignName() {
	return campaignNameText.getText();	
}

public WebElement createCampaignInfo(WebDriver driver)
{
campaignNameText.click();
return campaignNameText;
}

public String getcontactName() {
	return contactNameText.getText();	
}
}
