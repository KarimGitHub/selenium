package day6;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseHover {

	public static WebDriver driver;

	public static void main(String[] args) {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://store.demoqa.com/");

		driver.manage().window().maximize();

		Actions actions = new Actions(driver);

		actions.moveToElement(driver.findElement(By.linkText("Product Category"))).build().perform();

		driver.findElement(By.linkText("iMacs")).click();

	}

}