package Com.vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingMultipleData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream fisExcel = new FileInputStream("./src/test/resources/Book2.xlsx");
		Workbook wb = WorkbookFactory.create(fisExcel);
	Sheet sh = wb.getSheet("multipledata");
	for(int i=0; i<sh.getLastRowNum();i++)
	{
		for(int j=0; j<sh.getRow(i).getLastCellNum();j++)
		{
			System.out.println(sh.getRow(i).getCell(j).getStringCellValue());
		}
	}
	}
}
