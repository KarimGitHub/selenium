package day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();

		String URL = "http://www.dhtmlx.com/docs/products/dhtmlxTree/index.shtml";

		driver.get(URL);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Thread.sleep(3000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,9000)", "");

		Thread.sleep(5000);

		// WebElement From =
		// driver.findElement(By.xpath(".//*[@id='treebox1']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		WebElement From = driver.findElement(By.xpath(".//span[text()='Robert Crais']"));

		// WebElement To =
		// driver.findElement(By.xpath(".//*[@id='treebox2']/div/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[2]/table/tbody/tr[1]/td[4]/span"));
		WebElement To = driver.findElement(By.xpath(".//span[text()='Bestsellers']"));

		Actions builder = new Actions(driver);

		// builder.clickAndHold(From).moveToElement(To).release(To).build().perform();

		(new Actions(driver)).dragAndDrop(From, To).perform();

	}

}