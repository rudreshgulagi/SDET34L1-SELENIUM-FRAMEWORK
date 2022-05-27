package Com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewCampaignPage {

	
	@FindBy(xpath="//input[@name='campaignname']")
	private WebElement CampaignNameTxt;
	
	@FindBy(xpath="//input[@type='submit'and @value=\"  Save  \"]")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement ProductLookUp;
	

	//initialize the driver address to all the elements through constructors and make it as public 
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
	public void CreateNewCampaign(String campaignName) {
		CampaignNameTxt.sendKeys(campaignName);
	}
	public void SaveNewCampaign() {
		SaveBtn.click();
	}

	public void enterCampaignName(String campaignname) {
		CampaignNameTxt.sendKeys(campaignname);
	}
}