package Com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizationPage {

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement CreateOrganizationBtn;
	
	@FindBy(xpath ="(//input[@class='crmButton small save'])[1] ")
	private WebElement saveBtn;
	
	public CreateOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void CreateNew() {
		CreateOrganizationBtn.click();
}
	public void saveOrganizationpage()
	{
		saveBtn.click();
	}
}
