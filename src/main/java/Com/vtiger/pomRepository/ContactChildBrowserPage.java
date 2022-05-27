package Com.vtiger.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ctom.SDET34L1GenericUtility.WebDriverUtility;

public class ContactChildBrowserPage {
	
	@FindBy(xpath = "//input[@id='search_txt']")
	private WebElement contactDataChildBrowser;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement contactSearchChildBrowser;

	public ContactChildBrowserPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void childBrowsetHandels(WebDriver driver, String orgoName) {
     
		WebDriverUtility.switchToWindowBasedOnTitle(driver, "Organization");
		contactDataChildBrowser.sendKeys(orgoName);
		contactSearchChildBrowser.click();
		driver.findElement(By.xpath("//a[.='"+orgoName+"']")).click();
	}
	
	public void sendDataTochildBrowser1(String data)
	{
		
		contactDataChildBrowser.sendKeys(data);		
	}
	
	public void searchDataTochildBrowser1() {
		contactDataChildBrowser.click();		
	}

	
	public void sendDataTochildBrowser(String data)
	{
		
		contactDataChildBrowser.sendKeys(data);		
	}
	
	public void searchDataTochildBrowser() {
		contactDataChildBrowser.click();		
	}
}