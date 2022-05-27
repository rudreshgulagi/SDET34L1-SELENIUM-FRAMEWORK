package Com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNGAssertTest {
	
	SoftAssert softAssert=new SoftAssert();
	@Test(retryAnalyzer=Ctom.SDET34L1GenericUtility.RetryAnalyserImplementation.class)
	public void practice1Test() {
Reporter.log("a.practice1",true);
softAssert.assertEquals("123", "123");
Reporter.log("b.practice1",true);
Reporter.log("c.practice1",true);
softAssert.assertEquals("abc", "abc");
Reporter.log("d.practice1",true);
softAssert.assertEquals("pqrs", "xyz");
}
}
