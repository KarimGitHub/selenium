package day10;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LearnGrid {

	public static void main(String[] args) {

		RemoteWebDriver driver;
		try {
			String browser = "firefox";
			DesiredCapabilities dc = new DesiredCapabilities();
			dc.setBrowserName(browser);
			dc.setPlatform(Platform.WINDOWS);

			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://www.google.co.in");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
