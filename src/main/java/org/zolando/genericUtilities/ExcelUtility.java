package org.zolando.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class consist of reusable methods
 * 
 * @author PREM
 *
 */
public class ExcelUtility {
	private FileInputStream fis;
	private Workbook workBook;

	/**
	 * This method is used to get the data from the excel sheet
	 * 
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public String getDataFromEXcel(String sheetName, int rowNumber, int cellNumber) {
		String data = new DataFormatter()
				.formatCellValue(workBook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber));
		return data;
	}

	/**
	 * This method is used to set the data to Excel Sheet
	 * 
	 * @param excelPath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @param WriteData
	 */
	public void setDataToExcel(String sheetName, int rowNumber, int cellNumber, Date WriteData) {
		workBook.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(WriteData);
	}

	/**
	 * This method is used to open the excelWorkBook
	 * 
	 * @param excelPath
	 */
	public void openExcelWorkBook(String excelPath) {
		try {
			fis = new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workBook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to save the excelWorkBook
	 * 
	 * @param excelPath
	 */
	public void saveExcelWorkBook(String excelPath) {
		try {
			workBook.write(new FileOutputStream(excelPath));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	/**
	 * This method is used to close the excleWorkBook
	 */
	public void closeExcelWorkBook() {
		try {
			workBook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to get last row count
	 * 
	 * @param sheetName
	 * @return int
	 */
	public int getLastRowCount(String sheetName) {
		return workBook.getSheet(sheetName).getLastRowNum();
	}

	/**
	 * This method is used to get testData based on featureName
	 * 
	 * @param sheetName
	 * @param cellNumber
	 * @param add
	 * @param featureName
	 * @return String
	 */
	public Map<String, String> getDataStoreInMap(String sheetName, int cellNumber) {
		DataFormatter df = new DataFormatter();
		Sheet sheet = workBook.getSheet(sheetName);
		int lastRowCount = sheet.getLastRowNum();
		Map<String, String> data = new LinkedHashMap<String, String>(lastRowCount + 1);
		for (int i = 0; i <= lastRowCount; i++) {
			String key = df.formatCellValue(sheet.getRow(i).getCell(cellNumber));
			String value = df.formatCellValue(sheet.getRow(i).getCell(cellNumber + 1));
			data.put(key, value);
		}
		return data;
	}

	/**
	 * This method is used to add status into workBook(Pass or Fail)
	 * 
	 * @param sheetName
	 * @param cellNumber
	 * @param feature
	 * @param status
	 */
	public void setDataBasedOnPassAndfail(String sheetName, int cellNumber, String feature, String status) {
		DataFormatter df = new DataFormatter();
		Sheet sheet = workBook.getSheet(sheetName);
		int lastRowCount = sheet.getLastRowNum();
		String[] data = new String[lastRowCount + 1];
		for (int i = 0; i <= lastRowCount; i++) {
			data[i] = df.formatCellValue(sheet.getRow(i).getCell(cellNumber));
		}
		for (int i = 0; i <= lastRowCount; i++) {
			if (data[i].equals(feature)) {
				sheet.getRow(i).createCell(cellNumber + 1).setCellValue(status);
				break;
			}
		}
	}

	/**
	 * This method is used to stored data from excel to list<map<String,String>>
	 * then return data
	 * 
	 * @param sheetName
	 * @return List<Map<String, String>>
	 */
	public List<Map<String, String>> getDataFromExcelStoredInList(String sheetName) {
		Sheet sheet = workBook.getSheet(sheetName);
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		DataFormatter df = new DataFormatter();
		for (int i = 1; i < sheet.getRow(0).getLastCellNum(); i++) {
			Map<String, String> map = new LinkedHashMap<>();
			for (int j = 0; j <= sheet.getLastRowNum(); j++) {
				String key = df.formatCellValue(sheet.getRow(j).getCell(0));
				String value = df.formatCellValue(sheet.getRow(j).getCell(i));
				map.put(key, value);
			}
			list.add(map);
		}
		return list;
	}

	public String[][] getDataFromExcelStoredInTwoDimensionalArry(String sheetName) {
		Sheet sheet = workBook.getSheet(sheetName);
		int lastRow = getLastRowCount(sheetName);
		String[][] arry = new String[lastRow + 1][2];
		for (int i = 0; i <= lastRow; i++) {
			for (int j = 0; j <= 1; j++) {
				arry[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return arry;
	}
}
