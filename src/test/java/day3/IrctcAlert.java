package day3;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IrctcAlert {

	static RemoteWebDriver driver = null;

	static int i = 0;

	public static void main(String[] args) {

		learnAlerts("firefox");

	}

	public static void learnAlerts(String browserName) {

		if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.irctc.co.in/eticketing/loginHome.jsf");

		try {
			File src = driver.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./snapshots/irctc_" + i + ".jpg"));
			i++;

		} catch (IOException e) {
			System.out.println("SnapShot could not be taken");

		}

		driver.findElementById("loginbutton").click();

		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("jkhkfjds");
		// Click OK, Accept, 
		alert.accept();
		
		//Click Cancel
		//alert.dismiss();

		driver.close();

	}

}
