package day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;

public class googletest {

	public static void main(String[] args) {
		FirefoxDriver driver=new FirefoxDriver();
		driver.get("https://www.jquery.com");
//driver.screenshot s =new sceernshot();
		screenshot();

	}
public static void  screenshot ()
{
	FirefoxDriver driver = null;
	
	File srcFile = driver.getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(srcFile,new File("./shot/img.jpg"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
			
	// driver.getscreenshotAs();
	
	
}
}
