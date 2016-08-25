package day5;

import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderExample {

	public static String sheetPath = "C:\\Users\\Administrator\\Desktop\\TestData_xlsx.xlsx";
	String sSheet = "Sheet1";

	/*
	 * Test method will run after the DataProvider, used to read your Object[][]
	 * and run for no of rows Use the parameters depends on your no of columns
	 * in excel
	 */
	@Test(dataProvider = "ReadExcel")
	public void readExcelFile(String userName, String passWord, String seachKw) {
		System.out.println("userName -- " + userName + " -  passWord - "
				+ passWord + " - searchKw - " + seachKw);
	}

	/*
	 * DataProvider method The name you specified should match with @Test Return
	 * type should be Object[][]
	 */
	@DataProvider(name = "ReadExcel")
	public Object[][] dp() throws Exception {

		DataProviderExample obj = new DataProviderExample();

		Object[][] arrayObject = obj.readExcelUsingWorkBook(sheetPath, sSheet);
		return arrayObject;

	}

	/*
	 * Common method to read the excel file the return type should be [][] It is
	 * normal Apachi POI Xcel read and write method
	 */
	public String[][] readExcelUsingWorkBook(String excelFile, String sSheet)
			throws Exception {
		String[][] data = null;

		InputStream oFile;
		Row oRow = null;

		oFile = new FileInputStream(excelFile);
		Workbook oWBook = null;

		oWBook = WorkbookFactory.create(oFile);

		Sheet oSheet = oWBook.getSheet(sSheet);

		int maxRow = oSheet.getLastRowNum();

		int maxCellValue = oSheet.getRow(0).getLastCellNum();
		// Initialize your array size depends on your no of row and columns
		data = new String[maxRow][maxCellValue];

		// Read no of rows
		for (int i = 1; i < maxRow + 1; i++) {

			oRow = oSheet.getRow(i);
			maxCellValue = oRow.getLastCellNum();

			// Read no of columns
			for (int j = 0; j < maxCellValue; j++) {

				// Our intension to store values like [0][1] so using
				// i-1 since i starts from i=1
				data[i - 1][j] = returnCellType(oRow.getCell(j)).toString();
			}

		}

		return data;

	}

	/*
	 * Most generic method used to return type of your cell This is useful when
	 * you don't know the type of data your handling in excel its now handle
	 * Boolean , String, Numeric if your sheet may contain Date or Formulla
	 * please add it switch case
	 */
	public Cell returnCellType(Cell cellValue) {

		int cellTypeId = cellValue.getCellType();

		switch (cellTypeId) {
		// 1 > String
		case 1:
			cellValue.getStringCellValue();
			break;

		// 0 > numeric
		case 0:
			cellValue.getNumericCellValue();
			break;

		// 4> boolean
		case 4:
			cellValue.getBooleanCellValue();
			break;
		}

		return cellValue;
	}
}
