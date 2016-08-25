package day6;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnActionsClasses {

	// @Ignore
	// @Test
	public void dragAndDrop() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/droppable/");

		Actions action = new Actions(driver);

		driver.switchTo().frame(driver.findElementByXPath("//*[@id='content']/iframe"));

		WebElement src = driver.findElementById("draggable");

		WebElement dest = driver.findElementById("droppable");

		action.dragAndDrop(src, dest).build().perform();

		// action.contextClick().sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();

	}

	// @Test
	public void dragByOffset() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/draggable/");

		Actions action = new Actions(driver);

		driver.switchTo().frame(driver.findElementByXPath("//*[@id='content']/iframe"));

		WebElement src = driver.findElementById("draggable");

		action.dragAndDropBy(src, 100, 100).build().perform();

	}

	// @Test

	public void resizeWelement() throws InterruptedException {

		// System.setProperty("webdriver.chrome.driver",
		// "./drivers/chromedriver.exe");

		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("http://jqueryui.com/resizable/");

		driver.switchTo().frame(driver.findElementByXPath("//iframe[@class='demo-frame']"));

		WebElement resizeableElement = driver.findElementByXPath("//div[@id='resizable']/div[3]");

		Actions action = new Actions(driver);

		action.clickAndHold(resizeableElement).moveByOffset(100, 100).release().build().perform();

	}

	// @Test

	public void contextClick() {

		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("http://jqueryui.com/resizable/");

		driver.switchTo().frame(driver.findElementByXPath("//iframe[@class='demo-frame']"));

		WebElement resizeableElement = driver.findElementByXPath("//div[@id='resizable']/div[3]");

		Actions action = new Actions(driver);

		action.contextClick(resizeableElement).sendKeys(Keys.DOWN).sendKeys(Keys.PAUSE).sendKeys(Keys.DOWN)
				.sendKeys(Keys.PAUSE).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build().perform();

	}

//	@Test

	public void pageScroll() {

		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("http://jqueryui.com/resizable/");

		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0,9000)", "");

	}
	
	
	
	
//	@Test

	public void selectable() {

		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/selectable/");
		
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@class='demo-frame']"));

		WebElement srcItem = driver.findElementByXPath("//ol[@id='selectable']/li[1]");
		
		WebElement dstItem = driver.findElementByXPath("//ol[@id='selectable']/li[6]");
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(srcItem, dstItem).release(). build().perform();
		

	}
	
	
	@Test

	public void sortable() {

		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/sortable/");
		
		driver.switchTo().frame(driver.findElementByXPath("//iframe[@class='demo-frame']"));

		WebElement srcItem = driver.findElementByXPath("//ul[@id='sortable']/li[1]");
		
		WebElement dstItem = driver.findElementByXPath("//ul[@id='sortable']/li[6]");
		
		Actions action = new Actions(driver);
		
		action.dragAndDrop(srcItem, dstItem).build().perform();
		

	}
	
	
	
	
	
	
}
