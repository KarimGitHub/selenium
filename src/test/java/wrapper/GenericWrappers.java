package wrapper;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericWrappers implements Wrappers {
	// Declare Driver Class
	public RemoteWebDriver driver;
	public WebDriverWait wait;
	int i = 1;

	public void invokeApp(String browser, String Url) {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} else {
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 10);
			driver.get(Url);
			System.out.println("The application is launched");

		} catch (WebDriverException e) {
			System.out.println("Browser " + browser + " did not launch!");
			// e.printStackTrace();
           throw e  = new WebDriverException();
		} finally {
			takeSnap();

		}
	}

	// @Override
	public void enterById(String idValue, String data) {
		try {
			driver.findElementById(idValue).clear();
			driver.findElementById(idValue).sendKeys(data);
			System.out.println("The value " + data + " is entered");
		} catch (NoSuchElementException e) {
			System.out.println("Element " + idValue + " doesnt found!!");

		} catch (NullPointerException e) {
			System.out.println("Text " + data + " doesnt found!!");
		} catch (WebDriverException e) {
			// e.printStackTrace();
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}

	}

	// @Override
	public void enterByName(String nameValue, String data) {
		try {
			driver.findElementByName(nameValue).clear();
			driver.findElementByName(nameValue).sendKeys(data);
			System.out.println("The value " + data + " is entered");
		} catch (NoSuchElementException e) {
			System.out.println("Name " + nameValue + " doesnt found!!");
		} catch (NullPointerException e) {
			System.out.println("Text " + data + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}

	// @Override
	public void enterByXpath(String xpathValue, String data) {
		try {
			driver.findElementByXPath(xpathValue).clear();
			driver.findElementByXPath(xpathValue).sendKeys(data);
			System.out.println("The value "+ data + " is entered");

		} catch (NoSuchElementException e) {
			System.out.println("Xpath " + xpathValue + " does not exists!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}

	
	
	public void clearById(String id){
		try {
			driver.findElementById(id).clear();
		} catch (NoSuchElementException e) {
			System.out.println("ID " + id + " does not exists!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}
	
	public void clearByXpath(String xpath){
		try {
			driver.findElementById(xpath).clear();
		} catch (NoSuchElementException e) {
			System.out.println("Xpath " + xpath + " does not exists!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}
	
	public void clearByName(String name){
		try {
			driver.findElementById(name).clear();
		} catch (NoSuchElementException e) {
			System.out.println("Name " + name + " does not exists!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}

	// @Override
	public void verifyTitle(String title) {
		try {
			if (driver.getTitle().equals(title)) {
				System.out.println("Title " + title + " verification is success");
			} else {

				System.out.println("Title " + title + " verification is failed");
			}
			// need to confirm
		} catch (NullPointerException e) {
			System.out.println("Title " + title + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}

	}

	// @Override
	public void verifyTextById(String id, String text) {
		try {
			if (driver.findElementById(id).getText().equals(text)) {
				System.out.println("Title verification is success");
			} else {

				System.out.println("Title verification is failed");
			}
		} catch (NullPointerException e) {
			System.out.println("Text" + text + " doesnt found!!");
		} catch (NoSuchElementException e) {
			System.out.println("Xpath " + id + " does not exists!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}

	}

	// @Override
	public void verifyTextByXpath(String xpath, String text) {
		try {
			if (driver.findElementByXPath(xpath).getText().equals(text)) {
				System.out.println("Title verification is success");
			} else {

				System.out.println("Title verification is failed");
			}
		} catch (NullPointerException e) {
			System.out.println("Text " + text + " doesnt found!!");
		} catch (NoSuchElementException e) {
			System.out.println("Xpath " + xpath + " does not exists!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}

	// @Override
	public void verifyTextContainsByXpath(String xpath, String text) {
		try {
			String actualText = driver.findElementByXPath(xpath).getText();
			if (actualText.contains(text)) {
				System.out.println("The verification is Success");
			} else {
				System.out.println("The verification is fail");
			}

		} catch (NullPointerException e) {
			System.out.println("Text " + text + " doesnt found!!");
		} catch (NoSuchElementException e) {
			System.out.println("Xpath " + xpath + " does not exists!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}

	// @Override
	public void verifyTextContainsById(String id, String text) {
		try {
			if (driver.findElementById(id).getText().contains(text)) {
				System.out.println("The verification is Success");
			} else {
				System.out.println("The verification is fail");
			}
		} catch (NullPointerException e) {
			System.out.println("Text "+text + " doesnt found!!");
		} catch (NoSuchElementException e) {
			System.out.println("Element "+ id + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}

	}

	// @Override
	public void clickById(String id) {
		try {
			driver.findElementById(id).click();
		} catch (NoSuchElementException e) {
			System.out.println("Element " + id + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}

	}

	// @Override
	public void clickByClassName(String classVal) {
		try {
			driver.findElementByClassName(classVal).click();
			System.out.println("Click is successful");
		} catch (NoSuchElementException e) {
			System.out.println("Classname " + classVal + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}

	}

	// @Override
	public void clickByName(String name) {
		try {
			driver.findElementByName(name).click();
			System.out.println(" Click is successful");

		} catch (NoSuchElementException e) {
			System.out.println("Name " + name + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}

	}

	// @Override
	public void clickByLink(String name) {
		try {
			driver.findElementByLinkText(name).click();
		} catch (NoSuchElementException e) {
			System.out.println("LinkText " + name + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}

	// @Override
	public void clickByXpath(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
		} catch (NoSuchElementException e) {
			System.out.println("Xpath" + xpathVal + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}

	public void clickByXpathWOSnap(String xpathVal) {
		try {
			driver.findElementByXPath(xpathVal).click();
		} catch (NoSuchElementException e) {
			System.out.println("Xpath " + xpathVal + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		}

	}

	// @Override
	public String getTextById(String idVal) {
		try {
			// TODO Auto-generated method stub
			String txt = driver.findElementById(idVal).getText();
			return txt;
		} catch (NoSuchElementException e) {
			System.out.println("ID" + idVal + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
		return idVal;
	}

	// @Override
	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			String xpath_txt = driver.findElementByXPath(xpathVal).getText();
			return null;
		} catch (NoSuchElementException e) {
			System.out.println("Text " + xpathVal + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}

		return xpathVal;
	}

	// @Override
	public void selectVisibileTextById(String id, String value) {

		try {
			WebElement sel = driver.findElementById(id);
			Select sel_opt = new Select(sel);
			sel_opt.selectByVisibleText(value);
		} catch (NullPointerException e) {
			System.out.println("Text " + value + " doesnt found!!");
		} catch (NoSuchElementException e) {
			System.out.println("Element " + id + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}

	// @Override
	public void selectIndexById(String id, String value) {
		try {
			WebElement sel = driver.findElementById(id);
			Select sel_opt = new Select(sel);
			sel_opt.selectByValue(value);
		} catch (NullPointerException e) {
			System.out.println("Text " + value + " doesnt found!!");
		} catch (NoSuchElementException e) {
			System.out.println("Element " + id + " doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}

	}

	// @Override
	public void switchToParentWindowold() {
		try {
			Set<String> Winhandles = driver.getWindowHandles();
			String ParentHandle = driver.getWindowHandle();
			driver.switchTo().window(ParentHandle);
		} catch (NoSuchWindowException e) {
			System.out.println("Window doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}

	// @Override
	public void switchToParentWindow(String win) {
		try {
			// Set<String> Winhandles = driver.getWindowHandles();
			// String ParentHandle = driver.getWindowHandle();
			driver.switchTo().window(win);
		} catch (NoSuchWindowException e) {
			System.out.println("Window doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}

	// @Override
	public void switchToLastWindow() {
		try {
			Set<String> allwindows = driver.getWindowHandles();
			String ParentHandle = driver.getWindowHandle();
			int win_count = allwindows.size();
			System.out.println(win_count);
			for (String eachwin : allwindows) {
				driver.switchTo().window(eachwin);
				System.out.println(driver.getTitle());
			}
		} catch (NoSuchWindowException e) {
			System.out.println("Window doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}
	}

	// @Override
	public void switchToWindow(int winval) {
		try {
			Set<String> allwindows = driver.getWindowHandles();
			String ParentHandle = driver.getWindowHandle();
			int win_count = allwindows.size();
			System.out.println(win_count);
			int i = 0;
			for (String eachwin : allwindows) {
				if (i == winval) {
					driver.switchTo().window(eachwin);
					System.out.println(driver.getTitle());
				}
				i++;
			}
		} catch (NoSuchWindowException e) {
			System.out.println("Window doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}

	}

	// @Override
	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert doesnt found!!");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		} finally {
			takeSnap();
		}

	}
	
	
	// @Override
	public void takeSnap() {
		File src = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("./snaps/snap" + i + ".jpeg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		i++;

	}

	// @Override
	public void quitBrowser() {

		try {
			driver.quit();
			System.out.println("All browsers closed");
		} catch (WebDriverException e) {
			System.out.println("Browser did not launch!");
		}

	}

}
