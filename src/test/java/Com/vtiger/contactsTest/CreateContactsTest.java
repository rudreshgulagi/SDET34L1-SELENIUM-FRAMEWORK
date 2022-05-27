package Com.vtiger.contactsTest;

import org.testng.annotations.Test;

import Com.vtiger.pomRepository.ContactValidationPage;
import Com.vtiger.pomRepository.ContactsPage;
import Com.vtiger.pomRepository.CreateContactPage;
import Ctom.SDET34L1GenericUtility.BaseClass;
import Ctom.SDET34L1GenericUtility.MsExcel;

public class CreateContactsTest extends BaseClass {
	@Test
	public void createcontactspropertiesTest() 
	{
		String excel = MsExcel.getDatafromExcel("Contacts", 23, 1);
    	String excel1 = MsExcel.getDatafromExcel("Contacts", 24, 1);
		homepage.contactClick();
		ContactsPage contactsPage=new ContactsPage(driver);
		contactsPage.createContact();
		CreateContactPage contactpage=new CreateContactPage(driver);
		contactpage.firstName(excel);
		contactpage.lastName(excel1);
		contactpage.saveCreateContact();
		ContactValidationPage validation=new ContactValidationPage(driver);
		jutil.assertionThroughifCondition(validation.contactValidation(), excel, "Tc pass");
	}
}























