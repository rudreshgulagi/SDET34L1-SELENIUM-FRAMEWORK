package Com.vtiger.practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Ctom.SDET34L1GenericUtility.BaseClass;

public class organization extends BaseClass {
	
	@Test
	public void Orgnization() {
	homepage.organizationClick();
	String xpath = "//table[@class='lvt small']/tbody/tr[4]/td/a";
	List<WebElement> ColumnNames = driver.findElements(By.xpath("xpath"));
			for(WebElement orgname:ColumnNames)
			{
				System.out.println(orgname.getText());
			}
			driver.quit();
	    }
	  }