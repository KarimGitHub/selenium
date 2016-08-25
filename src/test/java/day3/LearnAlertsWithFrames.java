package day3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LearnAlertsWithFrames {

	public static void main(String[] args) {
		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();
		
		 

		driver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");

		driver.switchTo().frame("iframeResult");

		driver.findElementByXPath("//button[contains(text(),'Try it')]").click();

		Alert alert = driver.switchTo().alert();
		
		String text = alert.getText();
		
		System.out.println(text);

		// Will Click on OK button.
		alert.accept();
		
		System.out.println(" Alert closed");

		driver.close();

	}

}
