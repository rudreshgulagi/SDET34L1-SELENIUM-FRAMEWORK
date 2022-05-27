package Com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ctom.SDET34L1GenericUtility.WebDriverUtility;

public class OrganizationInformationPage {


	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement Org_Information;

	@FindBy(xpath="//input[@name='accountname']")
	private WebElement OrgNameTxt;

	@FindBy(xpath ="(//input[@class='crmButton small save'])[2] ")
	private WebElement saveBtn;

	@FindBy(xpath = "//select[@name='industry']")
	private WebElement industryDropDown;

	@FindBy(xpath = "//select[@name='accounttype']")
	private WebElement typeDropDown;

	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public String OrganInfo() {
		return Org_Information.getText();
	}
	public void OrgName(String OrgName)
	{
		OrgNameTxt.sendKeys(OrgName);
	}
	public void saveCreateOrg()
	{
		saveBtn.click();
	}
	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']")
	private WebElement organizationNameText;

	public void industryDropDown(String excel)
	{
      WebDriverUtility.intializeSelect(industryDropDown);
      WebDriverUtility.dropDownHandleByvalue(industryDropDown, excel);
	}	
	public void typeDropDown(String excel)
	{
		WebDriverUtility.intializeSelect(typeDropDown);
		WebDriverUtility.dropDownHandleByvalue(typeDropDown, excel);
	}


	public String getOrganizationName() {
		return organizationNameText.getText();	
	}
	}
