package Com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNGPractice1Test extends TestNGBasicConfigurationPracticeTest {

	@Test(groups="sanity")
	public void practicetest() {
		Reporter.log("BasicTestNGConfigurationTest", true);
	}
	@Test(groups="regression")
	public void practicetest1() {
	Reporter.log("BasicTestNGConfigurationTest1", true);
	}
	@Test(groups={"sanity","regression"})
	public void practicetest2() {
		Reporter.log("BasicTestNGConfigurationTest2", true);
	}
	@Test(groups="sanity")
	public void practicetest3() {
		Reporter.log("BasicTestNGConfigurationTest3", true);
	}
	@Test(groups="sanity")
	public void practicetest4() {
		Reporter.log("BasicTestNGConfigurationTest4", true);
	}
}


