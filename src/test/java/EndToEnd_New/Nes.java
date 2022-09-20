package EndToEnd_New;

import java.util.List;
import java.util.Map;

import org.zolando.genericUtilities.ExcelUtility;
import org.zolando.genericUtilities.IConstanceUtility;

public class Nes {
	public static void main(String[] args) {
		ExcelUtility excelUtility =new ExcelUtility();
		excelUtility.openExcelWorkBook(IConstanceUtility.EXCELPATH);
		List<Map<String, String>> list = excelUtility.getDataFromExcelStoredInList("TD1");
		System.out.println(list.get(1).get("category Name"));
		
	}
}
