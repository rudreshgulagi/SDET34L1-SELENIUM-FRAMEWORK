package Com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateOrganization;
	
	@FindBy(xpath = "//input[@name='accountname']")
	private WebElement organizationNameTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void createOrganization() {
		CreateOrganization.click();	
	}


	public void enterOrganizationNameTxtName(String organizationNameTxtName) {
		organizationNameTxt.sendKeys(organizationNameTxtName);
	}
	public void saveOrganization() {
		saveBtn.click();
	}
 
}
