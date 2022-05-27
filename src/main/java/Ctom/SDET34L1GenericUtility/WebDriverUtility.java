package Ctom.SDET34L1GenericUtility;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is class is used to maintain all webdriver common actions
 * @author rudresh
 *
 */
public class WebDriverUtility {
	static WebDriverWait wait;	
	static Select select =null;
	static Actions act=null;
	static JavascriptExecutor js;
	static JavaUtility jutil=new JavaUtility();
	
	WebDriver driver=null;
	/**
	 *  This method is used to navigate to the application
	 * @param url
	 * @param driver
	 */
	
	public  static void navigateApp(String url, WebDriver driver) {
		driver.get(url);
		}	
	/**
	 * This method is used to maximize the browser and implicitly wait
	 * @param longTimeOut
	 * @param driver
	 */
	public static void browserSetting(long longTimeOut, WebDriver driver) {
		maximizeBrowser(driver);
		waitTillpageload(longTimeOut, driver);
	}
	
	/**
	 *  This method is used to maximize the browser
	 * @param driver
	 */
	public static void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	/**
	 *  This method is used to implicitly wait till page Load
	 * @param longTimeOut
	 * @param driver
	 */
	public static void waitTillpageload(long longTimeOut, WebDriver driver) {
	driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}
	
	/**
	 * This method is used to mouse hover on the element
	 * @param moreLink
	 * @param driver
	 */
	public static void mouseHoverOntheElement(WebElement moreLink,WebDriver driver) {
		Actions act=new Actions(driver);
		act.moveToElement(moreLink).perform();
	}
	/**
	 * This method is used to double click the element 
	 * @param element
	 */
	public static void doubleClick(WebElement element) {
		
		act.doubleClick(element);	
	}
	
	/**
	 * this method is used close the browser
	 * @param driver
	 */
	
	public static void quitbrowser(WebDriver driver) {
		driver.quit();
	}
	
	/**
	 * This method is used to wait the control till the particularelement is clickable
	 * @param element
	 */
	public static void waitUntillElementClickable(WebElement element) {
	wait.until(ExpectedConditions.elementToBeClickable(element));	
	}

	
	/**
	 * This method is used to intilize wait instance
	 * @param driver
	 * @param timeout
	 */
	
	public static void explicitlyWait(WebDriver driver, long timeout) {
		wait=new WebDriverWait(driver, timeout);
	}
	
	/**
	 * This method is used to switch the window based on title
	 * @param driver
	 * @param partialText
	 */
	public static void switchToWindowBasedOnTitle(WebDriver driver, String partialText) {
		Set<String> sessionsIDs = driver.getWindowHandles();
		for(String id:sessionsIDs)
		{
			driver.switchTo().window(id);
			if(driver.getTitle().contains(partialText))
			{
				break;
			}
		}
	}
/**
 * This method is used to intialize the select class
 * @param element
 */
public static void intializeSelect(WebElement element) {
	
	select = new Select(element);
}
/**This method is used handle the dropdown by visibletext
 * This method is used 
 * @param element
 * @param visibletext
 */
public static void dropDownHandleByVisibleText(WebElement element, String visibletext) {
	select.selectByVisibleText(visibletext);
}

/**
 * This method is used handle the dropdown by index
 * @param element
 * @param intex
 */

public static void dropDownHandleByIndex(WebElement element, int index) {
	
	select.selectByIndex(index);
}
/**
 * This method is used handle the dropdown by value
 * @param element
 * @param value
 */

public static void dropDownHandleByvalue(WebElement element, String value) {
	select.selectByValue(value);
}

/**
 * This method is used handle the switchtoframe by index
 * @param driver
 * @param index
 */
public static void switchToFrame(WebDriver driver, int index)
{
	driver.switchTo().frame(index);
}

/**
 * This method is used to handle the switchtoframe by nameID
 * @param driver
 * @param nameID
 */
public static void switchToFrame(WebDriver driver, String nameID) {
	
	driver.switchTo().frame(nameID);
}

/**
 * This method is used to handle switchtoframe by element
 * @param element
 * @param driver
 */
public static void switchToFrame(String element ,WebDriver driver  ) {
	
	driver.switchTo().frame(element);
}

/**
 * This method is uesd to handle the switch back to mainframe
 * @param driver
 */

public static void switchBackToHome(WebDriver driver) {
	driver.switchTo().defaultContent();
}
/**
 * this method is used to initialize element
 * @param driver
 */
public static void intializeJs(WebDriver driver) {
	
js=(JavascriptExecutor) driver;
}
/**
 * this method is used to enter the data through javascript executor
 * @param element
 * @param data
 */
public static void enterDataThroughJs(WebElement element, String data) {
	
	js.executeScript("arguments[0].value=arguments[1]", element, data);
}
public static void clickThrouhgJs(WebElement element) {
	
	js.executeScript("arguments[0].click()",element);
}

public static void navigateApplicationThroughJs(String url) {
	js.executeScript("window.location=arguments[0]", url);
}

public static void scrollToSpaceFieldHegiht(String height) {
	js.executeScript("window.scrollBy(0,"+height+")");
}
public static void scrooToBottom() {
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
}
public static void scroolTillElement(WebElement element) {
	js.executeScript("arguments[0].scrollIntoView()",element);
}
/**
 * This method is used to take screenshot
 * @param fileName
 * @param driver
 * @return 
 * @throws IOException
 */
public static String takeScreenShot(String fileName, WebDriver driver,JavaUtility jutil) throws IOException {
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	File dst=new File("./Screenshoot/"+fileName+"_"+jutil.dataTimeInFormat()+".pngg");
    FileUtils.copyFile(src, dst);
    return dst.getAbsolutePath();
}
/**
 * This method is used to handle popup  and accept the alert
 * @param driver
 */
public static void alertAccept(WebDriver driver) {
	driver.switchTo().alert().accept();
}
/**
 * This method is used to handle popup and dismiss the alert
 * @param driver
 */
public static void alertDismiss(WebDriver driver) {
	driver.switchTo().alert().dismiss();

}
/**
 * This method is used to handle popup and send the aleart data
 * @param driver
 * @param data
 */
public static void alertSendData(WebDriver driver, String data) {
	driver.switchTo().alert().sendKeys(data);
}

public static String alertText(WebDriver driver, String data) {
	return driver.switchTo().alert().getText();
}
public static void rightClick() {
	act.contextClick().perform();
}
/**
 * this method is used to right click on the element
 * @param element
 */
public static void rightClick(WebElement element) {
	act.contextClick(element).perform();
}
}