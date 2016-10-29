package day3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LearnFrames {

	public static void main(String[] args) {

		int frameCount = 0;

	//	System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer.exe");

	//	InternetExplorerDriver driver = new InternetExplorerDriver();
		
		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://layout.jquery-dev.com/demos/iframes_many.html");

		List<WebElement> lstOfIframes = driver.findElementsByTagName("iframe");

		for (WebElement frames : lstOfIframes) {

			frameCount = frameCount + 1;

			driver.switchTo().frame(frames);

			List<WebElement> innerFrames = driver.findElementsByTagName("iframe");

			if (innerFrames.size() >= 1) {
				
				frameCount = frameCount + 1;

				for (WebElement innerFrame : innerFrames) {

					frameCount = frameCount + 1;

				}

			}

			driver.switchTo().defaultContent();
		}

		System.out.println("frames size is :" + frameCount);

		driver.close();

	}

}
