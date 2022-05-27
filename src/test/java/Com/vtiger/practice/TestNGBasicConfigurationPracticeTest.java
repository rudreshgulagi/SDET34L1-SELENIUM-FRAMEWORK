package Com.vtiger.practice;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class TestNGBasicConfigurationPracticeTest {
	
@BeforeSuite
public void beforesuitte1Test() {
Reporter.log("beforesuitte1", true);
	}
@AfterSuite(groups="sanity")
public void aftrsuitete1Test() {
	Reporter.log("aftrsuitete1", true);
}
@BeforeClass
public void beforesClass1Test() {
	Reporter.log("beforesClass1T", true);
}
@AfterClass(groups="regression")
public void beforeClass1Test() {
	Reporter.log("beforesClass1", true);
}
@BeforeTest
public void beforeTest1Test() {
	Reporter.log("beforeTest1", true);
}
@AfterTest
public void afterTest1Test() {
	Reporter.log("afterTest1", true);
}
@BeforeMethod
public void beforemethod1Test() {
	Reporter.log("beforemethod1", true);
}
@BeforeMethod
public void beforemethod2Test() {
	Reporter.log("beforemethod2", true);
}
@AfterMethod
public void aftermethod1Test() {
	Reporter.log("aftermethod1", true);
}
@AfterMethod
public void aftermethod2Test() {
	Reporter.log("aftermethod2", true);
}
}
