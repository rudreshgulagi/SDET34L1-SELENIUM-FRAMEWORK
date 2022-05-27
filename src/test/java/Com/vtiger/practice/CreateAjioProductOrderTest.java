package Com.vtiger.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAjioProductOrderTest {

  public static void main(String[] args) throws InterruptedException {
		  
		  WebDriverManager.chromedriver().setup();
		  ChromeOptions opt=new ChromeOptions();
		  opt.addArguments("--disable-notifications");
		  WebDriver driver=new ChromeDriver(opt);
		 driver.get("https://www.ajio.com/?gclid=CjwKCAjwgr6TBhAGEiwA3aVuIZOiSxiloPvjhNZyxqKFg9fGp7NXhDK1vr5CGHAF4slFDcyL_n2gVhoCngsQAvD_BwE");
		 driver.manage().window().maximize();
		 Thread.sleep(3000);
		  driver.findElement(By.xpath("//a[.='KIDS']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//a[@href='/s/starting-at-rs-199-4663-75761']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[.='Printed Shirt with Patch Pocket']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//span[.='7-8Y']")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//div[@class='pdp-addtocart-button']")).click();
		  
		/* Actions act=new Actions(driver);
		 act.moveToElement(kids);*/
		 
  }
}