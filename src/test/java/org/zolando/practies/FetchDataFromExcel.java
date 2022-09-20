package org.zolando.practies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel {
	public static void main(String[] args) {
		// step1---> convert physical file to java readable object
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// step2---> open the workbook
		Workbook book = null;
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//step3---> get the control on sheet
		Sheet sheet = book.getSheet("CommanData");
		//step4---> get the control on row
		Row row = sheet.getRow(0);
		//step5--->get the control on cell
		Cell cell = row.getCell(1);
		//step6--->fetch the data from cell
		String data = cell.getStringCellValue();
		System.out.println(data);
		System.out.println(cell.toString());
		try {
			book.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
