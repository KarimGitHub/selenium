package day10;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class BrowseFiles {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		ChromeDriver driver = new ChromeDriver();

		driver.get("http://my.naukri.com/account/register/basicdetails");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.manage().window().maximize();

		driver.findElementByXPath("/html/body/div/form/div[1]/div/button").click();
		
		driver.findElementByXPath("//*[@id='basicDetailForm']/resman-uploader/div/div[1]/span[1]/input")
				.sendKeys("D:\\Personal Project Development\\Selenium Training Course Details - Completion.docx");

	}

}
