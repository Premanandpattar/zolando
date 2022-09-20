
package org.zolando;

import org.testng.annotations.Test;
import org.zolando.genericUtilities.BaseClass;
import org.zolando.genericUtilities.MyProjectListener;

public class Test1 extends BaseClass{
	@Test
	public void test1() {
		MyProjectListener.log.info("log 1");
//		MyProjectListener listener=new MyProjectListener();
//		listener.log1.info("log 2");
	}
}
