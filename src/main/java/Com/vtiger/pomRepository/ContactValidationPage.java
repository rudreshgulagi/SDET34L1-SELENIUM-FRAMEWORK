package Com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactValidationPage {

	//validation
		@FindBy(xpath="//input[@name='firstname']")
		private WebElement FirstNameTxt;
		
		@FindBy(xpath="//input[@name='lastname']" )
		private WebElement lastnameTxt;
		
		//Constructor
		public ContactValidationPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
}
		public String contactValidation() 
		{
			return FirstNameTxt.getText();
		}
public WebElement  createcontactvalidation(WebDriver driver) 
{
	FirstNameTxt.click();
	return FirstNameTxt;
}
      public String contactvalidation()
      {
    	  return lastnameTxt.getText();
      }
      
      public WebElement creatcontactvalidation(WebDriver driver)
      {
    	  lastnameTxt.click();
    	  return lastnameTxt;
      }
}

