package devops;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DevopsRunner {
	
	@BeforeMethod
	
	public void beforeMethod(){
		
	}

	@AfterMethod
	public void aferMethod(){
		
	}
	
	@Test
	public void test2(){
		
	}
	@Test
	public void f() {

		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");

		try {
			File src = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./snapshots/irctc jpg"));

		} catch (IOException e) {
			System.out.println("SnapShot could not be taken");

		}

		driver.findElementById("loginbutton").click();

		Alert alert = driver.switchTo().alert();

		 
		// Click OK, Accept,
		alert.accept();

		// Click Cancel
		// alert.dismiss();

		driver.close();
	}
}
