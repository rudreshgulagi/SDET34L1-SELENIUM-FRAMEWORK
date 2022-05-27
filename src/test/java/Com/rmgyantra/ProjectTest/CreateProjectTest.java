package Com.rmgyantra.ProjectTest;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Ctom.SDET34L1GenericUtility.DatabaseUtility;
import Ctom.SDET34L1GenericUtility.FileUtilities;
import Ctom.SDET34L1GenericUtility.IconstantPath;
import Ctom.SDET34L1GenericUtility.JavaUtility;
import Ctom.SDET34L1GenericUtility.MsExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateProjectTest 
{
	public static void main(String[] args) throws IOException, SQLException {
		
		JavaUtility juti=new JavaUtility();
		FileUtilities.openPropertyFile(IconstantPath.RMGYANTRA_PROPERTYFILE_PATH);
	MsExcel.openExcel(IconstantPath.RMGYANTRA_EXCELFILE_PATH);
	int ran = juti.getRandomNumber(1000);
	String projectName = MsExcel.getDatafromExcel("projects", 2, 1)+"_"+ran;
	System.out.println(projectName);
	DatabaseUtility.openDBConnection(IconstantPath.DATABASEURL+FileUtilities.getDataFromPropertyFile("dbName"),FileUtilities.getDataFromPropertyFile("dbUserName"),FileUtilities.getDataFromPropertyFile("dbPassword"));
	DatabaseUtility.setDataInDataBase("insert into project values('TY_PROJ_65','Sanjay','28/04/2022','"+projectName+"','on Going',12);");
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://localhost:8084/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		
		List<WebElement> listofProjects=driver.findElements(By.xpath("//table//tbody/tr/td[2]"));
		for(WebElement project:listofProjects)
		{
			if(project.getText().equalsIgnoreCase(projectName)) {
				System.out.println("Project Name is vissible in GUI");
				System.out.println("Tc pass");
			}
		}
	}
	
}
		
	
		//WebDriverUtility.quiteBrowser(driver);
		
		/*driver.findElement(By.xpath("//span[.='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("sdet35ty");
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Mohan sir");
		WebElement ele = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
		Select s=new Select(ele);
		s.selectByIndex(1); 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement ele1 = driver.findElement(By.xpath("//td[.='sdet35ty']"));
		boolean p = ele1.isDisplayed();
	if(p)
	{
		System.out.println("project name displayed");
	}
	else
	{
		System.out.println("project name is not displayed");
	}
		
		
	}
	

}*/

	
	