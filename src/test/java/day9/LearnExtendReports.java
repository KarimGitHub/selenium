package day9;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class LearnExtendReports {

	private static ExtentTest test;
	private static ExtentReports extent;
	RemoteWebDriver driver;
	int i = 1;

	@Test
	public void runTestWithReports() {

		startResult();

		// It starts firefox browser
		driver = new FirefoxDriver();

		startTestCase();

		// To load the url
		driver.get("http://demo1.opentaps.org/opentaps/control/main");
		
		getScreenShot();

		// Set implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// maximize the windos
		driver.manage().window().maximize();

		// enter user name
		driver.findElementById("username").clear();
		driver.findElementById("username").sendKeys("DemoSalesManager");
		
		

		// enter user name
		driver.findElementById("password").clear();
		driver.findElementById("password").sendKeys("crmsfa");
		
		getScreenShot();

		driver.findElementByXPath("//*[@id='login']/p[3]/input").click();
		
		getScreenShot();

		driver.findElementByLinkText("CRM/SFA").click();
		
		getScreenShot();

		endResult();

		driver.close();

	}

	public void getScreenShot() {
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File("./reports/images/" + i + ".jpg"));
			
			
			test.log(LogStatus.PASS, "This testcase is used to check login functionality"+test.
					addScreenCapture("./../reports/images/"+i+".jpg"));
			
			i++;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

	public void startResult() {
		extent = new ExtentReports("./reports/result.html", true);
		extent.loadConfig(new File("./extent-config.xml"));
	}

	public void startTestCase() {
		test = extent.startTest("Opend Taps Login", "This testcase is used to check login functionality");
	}

	public void endResult() {
		extent.endTest(test);
		extent.flush();
	}

}
