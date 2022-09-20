package org.zolando.practies;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.Format;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchDataFromExcel_codeOptimize {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fisExcel = null;
		Workbook fb = null;
		try {
			fisExcel = new FileInputStream("./src/test/resources/TestData.xlsx");
			fb = WorkbookFactory.create(fisExcel);
			// getting only string value
			Sheet sheet = fb.getSheet("CommanData");
			String data = sheet.getRow(0).getCell(1).getStringCellValue();
			System.out.println(data);

			// getting any value in the form string
			Sheet sheet2 = fb.getSheet("Sheet2");
			String data1 = sheet2.getRow(0).getCell(0).toString();
			System.out.println(data1);

			// getting numeric value return type is double
			double data2 = sheet2.getRow(0).getCell(0).getNumericCellValue();
			System.out.println(data2);

			// Explicit type casting double to int (widening)
			int data3 = (int) sheet2.getRow(0).getCell(0).getNumericCellValue();
			System.out.println(data3);

			// data formatter. getting the data as per cell input
			//advantage--> not get null point exception
			DataFormatter df = new DataFormatter();
			String data4 = df.formatCellValue(sheet2.getRow(0).getCell(0));
			System.out.println(data4);

		} finally {
			fb.close();
		}

	}

}
