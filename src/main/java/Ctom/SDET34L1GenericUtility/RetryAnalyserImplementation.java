package Ctom.SDET34L1GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserImplementation implements IRetryAnalyzer{
	int maxRetry=4;
	int count=0;
	@Override
	public boolean retry(ITestResult result) {
		
		while(count<maxRetry);
		{
			count++;
		}
		return  false;
		}
	}