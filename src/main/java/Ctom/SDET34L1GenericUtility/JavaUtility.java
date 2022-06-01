package Ctom.SDET34L1GenericUtility;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import org.openqa.selenium.WebElement;

/**
 * This class contains only java specific reusable methods
 * @author rudresh
 *
 */
//COMMENTED
public class JavaUtility {
/**
 * This method is used to Convert String value to long datatype
 * @param value
 * @return
 */
	public static long stringTOLong(String value) {
		return Long.parseLong(value);
	}
	
	/**
	 * This method used to get the random Number
	 * @param limit
	 * @return
	 */
	public int getRandomNumber(int limit) {
		Random ran=new Random();
		return ran.nextInt(limit);
	}
	/**
	 * This method is used to print the message
	 * @param message
	 */
	public void printstatement(String message) {
		System.out.println(message);
	
	}
	/**
	 * This method is used validated the statement 
	 * @param actualResult
	 * @param expectedResult
	 * @param testCaseName
	 */

	public void assertionThroughifCondition(String actualResult, String expectedResult, String testCaseName) {
		if(actualResult.equalsIgnoreCase(expectedResult));
		{
			System.out.println(testCaseName+" created Successfully");
					System.out.println("TC pass");
		}
	}

	public void assertionThroughifConditionContains(String actualResult, String expectedResult, String testCaseName) {
		if(actualResult.contains(expectedResult));
		{
			System.out.println(testCaseName+" created Successfully");
					System.out.println("TC pass");
		}
	}
	
	/**
	 * This method is used to wait untill the element is clickable
	 * @param element
	 * @param polingtime
	 * @param duration
	 * @throws InterruptedException
	 */

	public void customWait(WebElement element, long polingtime, int duration) throws InterruptedException {
		int count = 0;
		while(count<=duration) {
			{
				try {
					element.click();
					break;
				}
				catch (Exception e) {
					Thread.sleep(polingtime*500);
					count++;
				}
			}
		}
	}

	public String dataTimeInFormat() {
		
	  return new	SimpleDateFormat("dd_MM_yyyy_HH_mm_sss").format(new Date(0));
	}
	}

