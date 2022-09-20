package EndToEnd_New;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.zolando.genericUtilities.ExcelUtility;
import org.zolando.genericUtilities.IConstanceUtility;

public class DataProviderTest {
	
	@Test(dataProvider = "getDataFromExcel")
	public void test(String city, int pincode) {
		System.out.println(Thread.currentThread().getId());
		System.out.println("city name is---->" + city);
		System.out.println("pincode is---->" + pincode);
		System.out.println();
	}

	@DataProvider(parallel = true)
	public Object[][] getData() {
		Object[][] obj = { { "bagaloure", 560022 }, { "vijayapur", 586113 }, { "bagalakot", 586001 } };
		return obj;
	}

	@DataProvider 
	public Object[][] getDataFromExcel() {
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.openExcelWorkBook(IConstanceUtility.EXCELPATH);
		Object[][] obj = excelUtility.getDataFromExcelStoredInTwoDimensionalArry("DataProvider");
		excelUtility.closeExcelWorkBook();
		return obj;
	}
}
