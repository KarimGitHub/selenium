package day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LearnAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirefoxDriver driver = new FirefoxDriver();
		
		driver.navigate().to("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_prompt");
		
		driver.switchTo().frame("iframeResult");
		
		driver.findElementByXPath("/html/body/button").click();
		
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Karim");
	System.out.println(driver.findElementById("demo").getText());

        alert.accept();
        driver.close();
	
	}
}
	