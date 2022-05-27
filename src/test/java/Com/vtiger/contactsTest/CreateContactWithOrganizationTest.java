package Com.vtiger.contactsTest;

import org.testng.annotations.Test;

import Com.vtiger.pomRepository.CampaignInformationPage;
import Com.vtiger.pomRepository.ContactChildBrowserPage;
import Com.vtiger.pomRepository.ContactsPage;
import Com.vtiger.pomRepository.CreateContactPage;
import Com.vtiger.pomRepository.CreateNewOrganizationPage;
import Com.vtiger.pomRepository.OrganizationPage;
import Ctom.SDET34L1GenericUtility.BaseClass;
import Ctom.SDET34L1GenericUtility.MsExcel;
import Ctom.SDET34L1GenericUtility.WebDriverUtility;

public class CreateContactWithOrganizationTest extends BaseClass {
	
	String organizationname;
	String contactname;
	CreateNewOrganizationPage createNewOrganization;
	OrganizationPage organizationPage;
	CreateContactPage createNewContact;
	ContactsPage contactPage;
	CampaignInformationPage contactInformationPage;
	ContactChildBrowserPage contactChildBrowser;
	
	@Test(groups={"sanity","regreesion"})
	public void createContactOrganization() throws InterruptedException {
	    organizationname = MsExcel.getDatafromExcel("Organization", 2, 1)+randomNumber;
		contactname = MsExcel.getDatafromExcel("Contacts", 0, 1)+randomNumber;
		homepage.organizationClick();
		 createNewOrganization=new CreateNewOrganizationPage(driver);
		 createNewOrganization.clickOnCreateOrganization();
		 organizationPage=new OrganizationPage(driver);
		 createNewContact=new CreateContactPage(driver);
		 contactPage=new ContactsPage(driver);
		organizationPage.enterOrganizationNameTxtName(organizationname);
		  organizationPage.saveOrganization();
		Thread.sleep(2000);
		  homepage.contactClick();
		  contactPage.createContact();
		  contactPage.enterContactNameTxtName(contactname);
		 createNewContact.saveCreateContact();
		 ContactChildBrowserPage contactChildBrowser=new ContactChildBrowserPage(driver);
		 contactPage.clickOnSelect();
		 WebDriverUtility.switchToWindowBasedOnTitle(driver, organizationname);
		 contactChildBrowser.childBrowsetHandels(driver, organizationname);
			WebDriverUtility.switchToWindowBasedOnTitle(driver, "Contacts");
		 contactPage.savecontact();
		 contactInformationPage=new CampaignInformationPage(driver);
			jutil.assertionThroughifCondition(contactInformationPage.getcontactName(),contactname,"Contact");	
	}
}