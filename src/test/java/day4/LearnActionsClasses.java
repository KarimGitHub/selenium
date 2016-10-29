package day4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class LearnActionsClasses {

	// @Test
	public void dragAndDrop() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/droppable/");

		Thread.sleep(5000);

		driver.switchTo().frame(driver.findElementByXPath("//*[@id='content']/iframe"));

		Actions action = new Actions(driver);

		WebElement src = driver.findElementById("draggable");

		WebElement dest = driver.findElementById("droppable");

		action.dragAndDrop(src, dest).build().perform();

		action.contextClick(dest).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();

	}

	@Test
	public void dragByOffset() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/draggable/");
		
		driver.switchTo().frame(driver.findElementByXPath("//*[@id='content']/iframe"));


		Actions action = new Actions(driver);

		// action.contextClick().pause(5000).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).click().build().perform();

		WebElement src = driver.findElementById("draggable");

		action.dragAndDropBy(src, 500, 500).build().perform();

	}

}
