package org.zolando;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.zolando.genericUtilities.BaseClass;
import org.zolando.genericUtilities.MyProjectListener;

public class Test2 extends BaseClass{

	@Test
	public void test2() {
		MyProjectListener.log.info("log 2");
		Reporter.log("hello",true);
//		MyProjectListener listener=new MyProjectListener();
//		listener.log1.info("log 2");
	}
}
