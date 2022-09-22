
package org.zolando;

import org.testng.annotations.Test;
import org.zolando.genericUtilities.ThreadSafeClass;

public class Test1 {
	@Test
	public void test1() {
		ThreadSafeClass.getTest().info("log 1");
		ThreadSafeClass.getTest().info("log 2");
		ThreadSafeClass.getTest().info("log 3");
		ThreadSafeClass.getTest().info("log 4");
		ThreadSafeClass.getTest().info("log 5");
		ThreadSafeClass.getTest().info("log 6");
		ThreadSafeClass.getTest().info("log 7");
		
		ThreadSafeClass.getTest().info("log 8");
//		MyProjectListener listener=new MyProjectListener();
//		listener.log1.info("log 2");
	}
}
