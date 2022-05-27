package Com.vtiger.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Ctom.SDET34L1GenericUtility.WebDriverUtility;

public class HomePage {

	@FindBy(xpath="//a[@href='index.php?module=Contacts&action=index']")
	 private WebElement contactLink;
	
	@FindBy(xpath="//a[@href='index.php?module=Accounts&action=index']")
	private WebElement organizationLink;
	
	@FindBy(xpath = "//a[.='Organizations']")
	private WebElement clickOnOrganization;
	
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement productLink;
	
	@FindBy(xpath = "//a[@href='index.php?module=Documents&action=index']")
	private WebElement documentsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreDropdown;
	
	@FindBy(xpath = "//a[@href='index.php?module=Campaigns&action=index']")
	private WebElement campaignsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;

	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signoutLink;
	
   public HomePage(WebDriver driver) {
   PageFactory.initElements(driver, this);
   
   }
   
  public void contactClick()
  {
	  contactLink.click();
  }
  public void organizationClick()
	{
		organizationLink.click();
	}
  public void clickOnOrganzations() {
		clickOnOrganization.click();
	}
  public void productClick()
	{
		productLink.click();
	}
  public void documentsClick()
	{
		documentsLink.click();	
	}
  public void campaignClick(WebDriver driver)
  {
  WebDriverUtility.mouseHoverOntheElement(moreDropdown, driver);
  campaignsLink.click();
}
  public void signout(WebDriver driver)
  {
	  WebDriverUtility.mouseHoverOntheElement(adminIcon, driver);
	  signoutLink.click();
  }
}
