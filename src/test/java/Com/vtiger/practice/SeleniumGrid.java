package Com.vtiger.practice;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumGrid {
	@Test
	public void SeleniumGridpractice() throws MalformedURLException {
		URL url=new URL("http://192.168.188.17:6666/wd/hub");
		DesiredCapabilities cap =new  DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		RemoteWebDriver driver=new RemoteWebDriver(url,cap);
		driver.get("http://gmail.com");
	}

}
