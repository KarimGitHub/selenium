package day7;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LearnWebTable {
	
	/*
	 * <table>
 	 *	 <tbody>
	 * 		<tr>
	 * 			<td>
	 * 			.
	 * 			.
	 * 			<td>
	 * 		</tr>
	 *			.
	 * 			.
	 * 		<tr>
	 * 			<td>
	 * 			.
     *			.
	 * 			<td>
	 * 		</tr>
	 * 	 </tbody>
	 * </table>
	 */

	public static void main(String[] args) {

		RemoteWebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://datatables.net/");

		// Inspect Table

		WebElement table = driver.findElementByXPath("//*[@id='example']");
		
		// Get into the Table Head with reference of Table

		WebElement tHead = table.findElement(By.tagName("thead"));
		
		// Get into the Table Row with reference of Table Head

		WebElement tHeadRow = tHead.findElement(By.tagName("tr"));
		
		// Get into the Table Header  with reference of Table Row, since 1st row is the header

		List<WebElement> tHeadTitle = tHeadRow.findElements(By.tagName("th"));

		System.out.println(" Table Header ");

		for (WebElement lsTHeadTitle : tHeadTitle) {
			
			System.out.print("  \t  " + lsTHeadTitle.getText());
		}

		System.out.println(" \n");

		System.out.println(" ___________________________________________________________ \n");
		
		// Get into the Table Body with reference of Table not from the Table Header

		WebElement tBody = table.findElement(By.tagName("tbody"));
		
		// Get into the Table Row's with reference of Table Body

		List<WebElement> tableRowsInner = tBody.findElements(By.tagName("tr"));

		System.out.println(" No Of Rows's are : " + tableRowsInner.size());
		
		// Iterate through the Row's of table since each table has many rows
		
		for (WebElement rows : tableRowsInner) {

			System.out.println("\n");

			System.out.println(" Get All Row's Columns \n");
			

			List<WebElement> lstOfEachRowColumns = rows.findElements(By.tagName("td"));

			System.out.println(" No Of <TD>'s  are : " + lstOfEachRowColumns.size());
			
			// Iterate through the Column's of table since each table has many rows

			for (WebElement lstOfColumns : lstOfEachRowColumns) {

				System.out.println(" \n " + lstOfColumns.getText());

			}

		}
		
		driver.close();

	}
}