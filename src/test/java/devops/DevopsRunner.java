package devops;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class DevopsRunner {
	
 
	@Test
	public void f() {
		
		int i=0;
		
		RemoteWebDriver driver;
		
//		System.setProperty("webdriver.chrome.driver", "D:/Workspace/Selenium_Online/learnselenium/drivers/chromedriver.exe");

//		driver = new ChromeDriver();

		  driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");

		driver.findElementById("loginbutton").click();

		Alert alert = driver.switchTo().alert();

		 
		// Click OK, Accept,
		alert.accept();

		// Click Cancel
		// alert.dismiss();
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./snapshots/irctc_" + i + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			i++;
		}
		
		driver.close();

	}
}
