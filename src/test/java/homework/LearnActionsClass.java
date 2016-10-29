package homework;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnActionsClass {

	public static void main(String[] args) throws IOException {

		// Launch the browser
		// FirefoxDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);

		driver.manage().window().maximize();

		// Launch the URL
		driver.get("https://jqueryui.com/draggable/");
		// Since the element is inside the ifram , swithch into the iFrame
		WebElement iFrameElement = driver.findElementByXPath("//*[@id='content']/iframe");
		driver.switchTo().frame(iFrameElement);
		// Find the element to draggable
		WebElement draggableElement = driver.findElementById("draggable");
		// Create Actions class since mouse over and action can be performed by
		// using action class
		Actions action = new Actions(driver);
		action.dragAndDropBy(draggableElement, 500, 500).build().perform();
		
		//Take sanp shot
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenShot, new File("./snaps/actions.jpg"));
		
		// To come out from iFrame use switchTo().defaultContent()
		driver.switchTo().defaultContent();
		// Mouse over on Contribute so use action class again , before that
		// check is the element is inside the iFrame or not
		WebElement contribute = driver.findElementByLinkText("Contribute");
		action.moveToElement(contribute).click().build().perform();
		// I am trying to select Bug Triage from Contribute
		// Note: There are two ways to pass web element, you can directly give
		// like below or can create webelment also can use
		action.moveToElement(driver.findElementByLinkText("Bug Triage")).click().build().perform();
		// Close the driver
		driver.close();

	}

}
