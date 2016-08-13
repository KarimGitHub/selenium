package day1;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumWithDifferentBrowsers {

	public static void main(String[] args) {
		
		FirefoxDriver driver = new FirefoxDriver();
		
//		System.setProperty("webdriver.chrome.driver",	"./drivers/chromedriver.exe");
		
//		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
		
		driver.manage().window().maximize();
		
		driver.get("https://www.google.co.in/");
		
		driver.findElementByXPath("//*[@id='lst-ib']").clear();
		
		driver.findElementByXPath("//*[@id='lst-ib']").sendKeys("Prasanth");
		
		driver.findElementByName("btnG").click();
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(src, new File("./snapshots/openTaps.jpg"));
		} catch (IOException e) {
			System.out.println("SnapShot could not be taken");
			
		}
		
		 driver.close();
	}

}
