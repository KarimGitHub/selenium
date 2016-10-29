package day2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {

	public static void main(String[] args) {

		//System.setProperty("webdriver.chrome.driver",	"./drivers/chromedriver.exe");
		
		InternetExplorerDriver driver = new InternetExplorerDriver();

		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);

		driver.manage().window().maximize();

		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");
		
		WebElement selectElement = driver.findElementById("userRegistrationForm:securityQ");

		Select dropDown = new Select(selectElement);

		List<WebElement> secQuestions = dropDown.getOptions();
		System.out.println(" Print All Questions");
		for (WebElement webElement : secQuestions) {
		
			System.out.println(webElement.getText());

		}
		
		List<WebElement> selectedOptions = dropDown.getAllSelectedOptions();
		
		System.out.println("Selected Options");
		
		for (WebElement webElement : selectedOptions) {
			
			System.out.println(webElement.getText());
		}
		
		System.out.println(" Select Question by visible text");
		dropDown.selectByVisibleText("What is your pet name?");
		
		
		System.out.println(" Select Question by index");
		dropDown.selectByIndex(5);
		
		
		System.out.println(" Select Question by value");
		dropDown.selectByValue("6");

	}

}
