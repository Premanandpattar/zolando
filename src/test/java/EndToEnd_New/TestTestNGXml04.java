package EndToEnd_New;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.zolando.genericUtilities.BaseClass;

public class TestTestNGXml04 extends BaseClass{

	@Test (groups = "regression")
	public void test04(Method mtd) {
		Reporter.log(mtd.getName() + " thread count is "+Thread.currentThread().getId(),true);
//		System.out.println(getClass().getSimpleName());
	}
}
