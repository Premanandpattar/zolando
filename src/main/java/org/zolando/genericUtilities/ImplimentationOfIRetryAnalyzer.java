package org.zolando.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ImplimentationOfIRetryAnalyzer implements IRetryAnalyzer {

	int count=0;
	int max=4;
	@Override
	public boolean retry(ITestResult result) {
		if (count<max) {
			count++;
			return true;
		}
		return false;
	}

}
