package day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Snippet {
	
	@Test
	public void dragByOffset() throws InterruptedException {
	
		/*System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	
		driver = new ChromeDriver();*/
		
		FirefoxDriver	driver = new FirefoxDriver();
	
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		driver.manage().window().maximize();
	
		driver.get("https://jqueryui.com/draggable/");
	
		Actions action = new Actions(driver);
	
		driver.switchTo().frame(driver.findElementByXPath("//*[@id='content']/iframe"));
	
		WebElement src = driver.findElementById("draggable");
	
		action.dragAndDropBy(src, 100, 100).build().perform();
	
	}
}

