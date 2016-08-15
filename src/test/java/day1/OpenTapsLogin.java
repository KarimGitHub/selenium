package day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;

public class OpenTapsLogin {

	public static void main(String[] args) {
		
		
		//http://demo1.opentaps.org/opentaps/control/main
		
		//username
		//password
		//decorativeSubmit
    // FF ///html/body/div[2]/div[2]/div[1]/form[1]/p[3]/input
	// Chrome	//*[@id="login"]/p[3]/input
		//
		
		//class name should not have spaces
		
		// It starts firefox browser
		FirefoxDriver driver = new FirefoxDriver();
		
		
		// To load the url
		driver.get("http://demo1.opentaps.org/opentaps/control/main");
		
		
		//Set implicit wait
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
		 
		 //maximize the windos
		 driver.manage().window().maximize();
		 
		 
		 //enter user name
		 driver.findElementById("username").clear();
		 driver.findElementById("username").sendKeys("DemoSalesManager");
		 
		 //enter user name
		 driver.findElementById("password").clear();
		 driver.findElementById("password").sendKeys("crmsfa");
		 
		 
		 
		 driver.findElementByXPath("//*[@id='login']/p[3]/input").click();
		 
		 	
		driver.findElementByLinkText("CRM/SFA").click();
	 

	}

}
