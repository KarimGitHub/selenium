package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",	"./drivers/chromedriver.exe");
		
		ChromeDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");

		Select dropDown = new Select(driver.findElementById("userRegistrationForm:securityQ"));

		List<WebElement> secQuestions = dropDown.getOptions();

		for (WebElement webElement : secQuestions) {
			System.out.println(" Print All Questions");
			System.out.println(webElement.getText());

		}
		List<WebElement> selectedOptions = dropDown.getAllSelectedOptions();
		
		for (WebElement webElement : selectedOptions) {
			System.out.println("Selected Options");
			System.out.println(webElement.getText());
		}
		
		System.out.println(" Select Question by visible text");
		dropDown.selectByVisibleText("What is your pet name?");
		
		
		System.out.println(" Select Question by index");
		dropDown.selectByIndex(5);
		
		
		System.out.println(" Select Question by value");
		dropDown.selectByValue("5");

	}

}
