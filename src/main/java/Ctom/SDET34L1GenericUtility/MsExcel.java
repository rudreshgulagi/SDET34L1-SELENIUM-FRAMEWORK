package Ctom.SDET34L1GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this class is used to maintain the all the excel specific common methods
 * @author rudresh
 *msexcel
 */

public class MsExcel{
	static Workbook wb;
	
	
	public static void openExcel(String filePath) throws EncryptedDocumentException, IOException{
	FileInputStream fisExcel = new FileInputStream(filePath);
	wb=WorkbookFactory.create(fisExcel);
}
/**
 * this method is used tofetch the data from the excel sheet
 * @param sheetname
 * @param rowNumber
 * @param cellNumber
 * @return
 */
public static String getDatafromExcel(String sheetname,int rowNumber,int cellNumber) {
	
	
	String data=wb.getSheet(sheetname).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	return data;
}
/**
 * method is used to fetch the multiple data from the Excel sheet
 * @param sheetName
 * @return
 */
public static Object[][] getMultipleDataFromExcel(String sheetName){
	Sheet sh=wb.getSheet(sheetName);
	Object[][] arr=new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];
	for(int i=0; i<sh.getLastRowNum(); i++)
	{
		for(int j=0; j<sh.getRow(i).getLastCellNum(); j++)
		{
			arr[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
		}
	}
	return arr;
}

/**
 * This method is used to create and set cell value into Excel
 * @param sheetName
 * @param rowNumber
 * @param cellNumber
 * @param value
 */
public static void setDataIntoExcel(String sheetName, int rowNumber, int cellNumber, String value) {
wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).setCellValue(value);
}

/**
* This method is used to write in the Excel
* @param fileSavePath
*/
public void saveExcelData(String fileSavePath)  {
FileOutputStream fos = null;
try {
	fos = new FileOutputStream(fileSavePath);
} catch (FileNotFoundException e) {
							
	e.printStackTrace();
}
try {
	wb.write(fos);
} catch (IOException e) {
	
	e.printStackTrace();
}
}
/**
* This method is used to close the Excel
*/
public static void closeExcel() {
try {
	wb.close();
} catch (IOException e) {
	
	e.printStackTrace();
	//ghgfhzd
}
}
}