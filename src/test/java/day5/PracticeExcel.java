package day5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PracticeExcel {

	public static void main(String[] args) {

		PracticeExcel excel = new PracticeExcel();

		// excel.readExcel();

		// excel.writeExcel();

		excel.updateExcel();

	}

	public void readExcel() {
		
		XSSFWorkbook wbook = null;
		
		try {
			
			// Opening the file from physical path
			FileInputStream ipStream = new FileInputStream(new File("./data/TestCaseTracker.xlsx"));
			
			// To read .xlsx please use XSSFWorkbook
			wbook = new XSSFWorkbook(ipStream);
			
			// Index start with 0 -> I want to read the 1st excel sheet
			// Even you can open the sheet with name of sheet
			XSSFSheet sheet = wbook.getSheetAt(0);
			 
			
			System.out.println(" Read The Sheet Name");
			
			System.out.println("Sheet Name : " + sheet.getSheetName());

			XSSFRow row = sheet.getRow(1);

			/*System.out.println("Read the column values");

			System.out.println(row.getCell(0));

			System.out.println(row.getCell(1));

			System.out.println("Get the last rows ");

			System.out.println(sheet.getLastRowNum());
*/
			System.out.println("________________________________-");

			int lastRowNumber = sheet.getLastRowNum();

			int lastColumnNumber;

			for (int i = 1; i <= lastRowNumber; i++) {

				XSSFRow rows = sheet.getRow(i);
				
				// Get the last cell number
				lastColumnNumber = rows.getLastCellNum();

				for (int j = 0; j < lastColumnNumber; j++) {

					System.out.println(rows.getCell(j));
				}

			}

			

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				wbook.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void writeExcel() {

		try {
			FileOutputStream outSteam = new FileOutputStream(new File("./data/TestCaseTracker_update.xlsx"));

			XSSFWorkbook wbook = new XSSFWorkbook();

			XSSFSheet sheet = wbook.createSheet("Updated");

			XSSFRow row = sheet.createRow(0);

			XSSFCell cell1 = row.createCell(0);

			cell1.setCellValue("Test Case #");

			XSSFCell cell2 = row.createCell(1);

			cell2.setCellValue("Test Case");

			XSSFCell cell3 = row.createCell(2);

			cell3.setCellValue("Test Case Ran");

			wbook.write(outSteam);

			wbook.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void updateExcel() {

		try {
			FileInputStream ipStream = new FileInputStream(new File("./data/TestCaseTracker.xlsx"));

			XSSFWorkbook wbook = new XSSFWorkbook(ipStream);

			XSSFSheet sheet = wbook.getSheetAt(0);
			System.out.println(" Read The Sheet Name");
			System.out.println("Sheet Name : " + sheet.getSheetName());

			XSSFRow row = sheet.getRow(1);

			System.out.println("Read the column values");

			System.out.println(row.getCell(0));

			System.out.println(row.getCell(1));

			System.out.println("Get the last rows ");

			System.out.println(sheet.getLastRowNum());

			System.out.println("________________________________-");

			int lastRowNumber = sheet.getLastRowNum();

			int lastColumnNumber;

			for (int i = 1; i < lastRowNumber; i++) {

				XSSFRow rows = sheet.getRow(i);

				lastColumnNumber = rows.getLastCellNum();

				for (int j = 0; j < lastColumnNumber; j++) {

					System.out.println(rows.getCell(j));
				}

			}

			// Update Excel Sheet

			row = sheet.createRow(4);

			XSSFCell cell = row.createCell(0);

			cell.setCellValue("Karim");
			
			XSSFCell cell1 = row.createCell(1);
			
			cell1.setCellValue("Prasanth");

			ipStream.close();

			FileOutputStream outSteam = new FileOutputStream(new File("./data/TestCaseTracker.xlsx"));

			wbook.write(outSteam);
			wbook.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
