package org.zolando.practies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcelStoreInTwoDimensionalArray {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");
		DataFormatter df = new DataFormatter();
		int highestCellNumber = 0;
		try {
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				int number = sheet.getRow(i).getLastCellNum();
				if (highestCellNumber < number) {
					highestCellNumber = number;
				}
			}
		} finally {
			wb.close();
		}
		String[][] arr = new String[sheet.getLastRowNum() + 1][highestCellNumber];
		try {
			for (int i = 0; i <= sheet.getLastRowNum(); i++) {
				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
					arr[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
				}

			}
		} finally {
			wb.close();
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < highestCellNumber; j++) {
				String d = arr[i][j];
//				if (d.equals("null")) {
//
//				} else {
					System.out.print(d + " ");
//				}
			}
			System.out.println();
		}

		
	}
}
