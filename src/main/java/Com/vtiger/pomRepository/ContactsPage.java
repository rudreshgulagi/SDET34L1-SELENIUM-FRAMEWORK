package Com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContact;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactpageNameTxt;
	
	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement contactNameTxt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
	
	@FindBy(xpath = "//img[@title='Select']")
    private WebElement selectBtn;
	
	@FindBy(xpath="//select[@name='viewname']")
	private WebElement clickonFilter;
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void createContact() {
		createContact.click();	
	}
	
	public void savecontact() {
		saveBtn.click();
	}

	public void clickOnSelect() {
		selectBtn.click();
	}
	public void clickonfilter() {
		clickonFilter.click();
	}

	public void enterContactNameTxtName(String contactNameTxtName) {
		contactNameTxt.sendKeys(contactNameTxtName);
		
	}

}


