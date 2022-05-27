package Com.vtiger.Document.Project.Test;

import org.testng.annotations.Test;

import Com.vtiger.pomRepository.CreateNewDocumentPage;
import Com.vtiger.pomRepository.DocumentInfoPage;
import Com.vtiger.pomRepository.DocumentPage;
import Ctom.SDET34L1GenericUtility.BaseClass;
import Ctom.SDET34L1GenericUtility.MsExcel;

public class CreateDocument extends  BaseClass{
	String document;
	String documentpath;
	String documentdescription;
	CreateNewDocumentPage createNewDocument;
	 DocumentPage  documentPage;
	 DocumentInfoPage documentInfoPage;
	@Test(groups={"sanity","regreesion"})
	public void createDocumentWithFrames() throws InterruptedException {
		   document = MsExcel.getDatafromExcel("document", 0, 1)+randomNumber;
		   documentpath =MsExcel.getDatafromExcel("document", 1, 1);
		   documentdescription =MsExcel.getDatafromExcel("document", 1, 2);
		    homepage.documentsClick();
		    createNewDocument=new CreateNewDocumentPage(driver);
		    createNewDocument.clickOnCreateDocument();
		    documentPage=new DocumentPage(driver);
		    documentPage.enterdocumentNameTxtName(document);
		    Thread.sleep(2000);
		    driver.switchTo().frame(0);
		    documentPage.enterdocumentinfoTxt(documentdescription);
		    driver.switchTo().defaultContent();
		    documentPage.clickOnBold();
		    documentPage.clickOnItalic();
		    documentPage.clickOnFiles(documentpath);
		    documentPage.saveDocument();
		    documentInfoPage=new DocumentInfoPage(driver);

		    jutil.assertionThroughifCondition(documentInfoPage.getDocumentName(),document ,"Document");	
	}
}