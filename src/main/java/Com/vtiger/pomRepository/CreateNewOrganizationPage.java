package Com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganizationPage {

	
	@FindBy(xpath="//input[@class='detailedViewTextBox' and @name='accountname']")
	private WebElement OrganizationNameTxt;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateOrganizationBtn;
	
	@FindBy(name=("button"))
	private WebElement SaveBtn;
	
	@FindBy(xpath="//input[@class='txtBox']")
	private WebElement SearchNameTxt;
	
	
	
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void enterOrganizationName(String organization_name) {
		OrganizationNameTxt.sendKeys(organization_name);	
	}
	
	public void SaveOrg() {
		SaveBtn.click();
	}


	public void clickOnCreateOrganization() {
		CreateOrganizationBtn.click();
			
		}
	public void enterSearchName(String organization_name) {
		SearchNameTxt.sendKeys(organization_name);	
	}
		
	}
		
	
	
