package Com.vtiger.practice;

import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPopup {
	
	@Test
	public void test1()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		 String reqDate = "27";
		 String reqMonth = "August";
		 String reqYear = "2021";
		  int reqMonthyear = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqMonth).get(ChronoField.MONTH_OF_YEAR);
		  int reqYearinNumber = Integer.parseInt(reqYear);
		 String[] currentreqMonthyear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText().split("");
		  String currentMonth = currentreqMonthyear[0];
		  int currentreqMonthofyear=DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(currentMonth).get(ChronoField.MONTH_OF_YEAR);
		String currentyear = currentreqMonthyear[1];
		int currentyearinNumber = Integer.parseInt(currentyear);
		
		while(reqYearinNumber<currentyearinNumber||)
		
	}

}
