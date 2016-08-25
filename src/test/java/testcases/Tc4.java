package testcases;

import java.util.Set;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import wrapper.GenericWrappers;


public class Tc4 extends GenericWrappers {

	@Test
	public void mergeLead() {

		// login
		invokeApp("chrome", "http://demo1.opentaps.org");
		enterById("username", "DemoSalesManager");
		enterById("password", "crmsfa");
		clickByClassName("decorativeSubmit");
		clickByLink("CRM/SFA");
		clickByLink("Leads");
		clickByLink("Merge Leads");
		clickByXpath("(//img[@alt='Lookup'])[1]");
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		Set<String> allWin = driver.getWindowHandles();
		String ParentHandle = driver.getWindowHandle();
		int i = 1;
		int j = 1;
		for (String eachWin : allWin) {
			if (i == 2) {
				driver.switchTo().window(eachWin);

				enterByName("id", "10022");
				clickByXpath("//button[text()[contains(.,'Find Leads')]]");
				clickByXpathWOSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
			}
			i++;
		}
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		switchToParentWindow(ParentHandle);

		// search to lead
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//img[@alt='Lookup'])[2]")));
		clickByXpath("(//img[@alt='Lookup'])[2]");
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		// switchToLastWindow();
		Set<String> allWin2 = driver.getWindowHandles();
		String ParentHandle2 = driver.getWindowHandle();

		for (String eachWin2 : allWin2) {
			if (j == 2) {

				enterByName("id", "10023");
				clickByXpath("//button[text()[contains(.,'Find Leads')]]");
				wait.until(ExpectedConditions.elementToBeClickable(
						By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]")));
				clickByXpathWOSnap("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a)[1]");
			}
			j++;
		}
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		switchToParentWindow(ParentHandle2);

		// merge lead
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Merge")));
		clickByLink("Merge");

		// handle alert
		wait.until(ExpectedConditions.alertIsPresent());
		acceptAlert();

		// find duplicate
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Find Leads")));
		clickByLink("Find Leads");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("id")));
		enterByName("id", "10010");
		clickByXpath("//button[text()[contains(.,'Find Leads')]]");
		if (driver.findElementByXPath("//div[contains(text(),'No records to display')]").getText()
				.equals("No records to display")) {

			System.out.println("Leads merged successfully!!!");
		} else {
			System.out.println("OOPS.Leads doesnt merged!!!");

		}
		quitBrowser();

	}

}
