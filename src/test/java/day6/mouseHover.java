package day6;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class mouseHover {

	public static RemoteWebDriver driver;

	public static void main(String[] args) {

		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://store.demoqa.com/");

		driver.manage().window().maximize();

		Actions actions = new Actions(driver);

		actions.moveToElement(driver.findElement(By.linkText("Product Category"))).build().perform();

		driver.findElement(By.linkText("iMacs")).click();
		
		File src = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./snapshots/irctc.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			 
		}

	}

}