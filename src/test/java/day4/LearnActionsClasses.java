package day4;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class LearnActionsClasses {

	@Test
	public void dragAndDrop(){
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/droppable/");

		Actions action = new Actions(driver);
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		WebElement src = driver.findElementById("draggable");
		
		WebElement dest = driver.findElementById("droppable");
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		action.dragAndDrop(src, dest).build().perform();
		 
		
//		action.contextClick().sendKeys(Keys.DOWN).sendKeys(Keys.DOWN).build().perform();
	
		
	}
	
//	@Test
	public void dragByOffset(){
		
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		FirefoxDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/draggable/");

		Actions action = new Actions(driver);
	
		WebElement src = driver.findElementById("draggable");

		action.dragAndDropBy(src, 500, 500);
		
	}
	
}
