package day4;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnWindowHandles {

	@Test
	public void windowHandles() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://legacy.crystalcruises.com/login.aspx");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElementByTagName("ALREADY BOOKED")).click().build().perform();

		driver.findElementByTagName("Guest Check-in").click();

		driver.close();

	}
}
