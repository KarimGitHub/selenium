package day7;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GenericWrappers {

	RemoteWebDriver driver;

	String testCaseName = "lkadlkfj";

	public void invokeApp(String url, String browserName) throws IOException {

		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");

				driver = new InternetExplorerDriver();

			} else {
				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			driver.get(url);
		} catch (NoSuchElementException e) {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getSnapShot();
		}

	}

	public void enterValueById(String element, String elemeneValue) {

		driver.findElementById(element).sendKeys(elemeneValue);

	}

	public void enterValueByName(String element, String elemeneValue) {

		driver.findElementByName(element).sendKeys(elemeneValue);

	}

	public void clickById(String element) {
		driver.findElementById(element).clear();
	}

	public void verifyTitleById(String element, String originalValue) {

		try {
			String title = driver.getTitle();
			if (title.equals(originalValue)) {

			}

		} catch (Exception e) {

		}

	}

	public void getSnapShot() throws IOException {

		File src = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./snapshots/irctc.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			getSnapShot();
		}

	}

	public String getName() {
		System.out.println("Selenium Login");
		return "Selenium Login";

	}

	public void setName(String name) {

		System.out.println(" Name set : " + name);
	}

}
