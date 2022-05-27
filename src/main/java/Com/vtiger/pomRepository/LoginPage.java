package Com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement userNameTxt;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement passwordTxt;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	//Businesslibrary
	
 public void loginToApp(String userName,String password)
 {
	 userNameTxt.sendKeys(userName);
	 passwordTxt.sendKeys(password);
	 submitBtn.click();
 }
}
