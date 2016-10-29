package day1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectSelenium {

	public static void main(String[] args) {

		FirefoxDriver driver = new FirefoxDriver();

		driver.get("https://www.irctc.co.in/eticketing/userSignUp.jsf");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);

		WebElement wElement = driver.findElementById("userRegistrationForm:securityQ");

		Select select = new Select(wElement);

		List<WebElement> countryList = select.getOptions();
		
		int count = countryList.size() - 1;
		
		System.out.println(countryList.get(count).getText());
		
		select.selectByIndex(count);
		
		driver.close();
	}

}
