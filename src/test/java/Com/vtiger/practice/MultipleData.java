package Com.vtiger.practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Ctom.SDET34L1GenericUtility.IconstantPath;
import Ctom.SDET34L1GenericUtility.MsExcel;

public class MultipleData {

	
		
		@Test(dataProvider="multipledata")
		
		public void multipledataTest(String username,String password) {
			Reporter.log(username+"......>  "+password, true);	
	}
		@DataProvider
		public Object[][] multipledata() throws EncryptedDocumentException, IOException{
			MsExcel.openExcel(IconstantPath.EXCELPATH);
		return MsExcel.getMultipleDataFromExcel("multipledata");
}
}