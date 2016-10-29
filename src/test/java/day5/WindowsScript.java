package day5;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class WindowsScript {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		FirefoxDriver driver = new FirefoxDriver();

		driver.get("http://toolsqa.wpengine.com/automation-practice-switch-windows/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		// Get the current window object

		String parent = driver.getWindowHandle();

		System.out.println(" Parent window Object  :: " + parent);

		System.out.println(driver.getTitle());

		Thread.sleep(2000);

		//driver.findElementByXPath("//*[@class='ib-img-default']").click();

	//	Thread.sleep(2000);

		driver.findElementByXPath("//button[text()='New Browser Window']").click();

		// Return both current and new windows opened
		Set<String> handles = driver.getWindowHandles();

		System.out.println("Size of windows : " + handles.size());

		for (String handle1 : handles) {

			driver.switchTo().window(handle1);
			System.out.println(driver.getTitle());

		}

		// now the control not in the parent window , it now in child window

	//	driver.findElementByXPath("//*[@class='ib-img-default']").click();

		driver.manage().window().maximize();

		driver.close();

		driver.switchTo().window(parent);

		driver.findElementByXPath("//button[text()='New Message Window']").click();

		// driver.close();

	}

}
