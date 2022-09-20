package EndToEnd_New;

import java.lang.reflect.Method;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.zolando.genericUtilities.BaseClass;

public class TestTestNGXml01 extends BaseClass {

	@Test(groups = "sanity")
	public void test01(Method mtd) {
		Reporter.log(mtd.getName() + " thread count is "+Thread.currentThread().getId(),true);
//		System.out.println(getClass().getSimpleName());
	}
}
