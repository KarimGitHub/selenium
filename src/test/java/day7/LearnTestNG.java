package day7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LearnTestNG {

	@BeforeSuite
	public void wakeupAndMakeup() {
		System.out.println("Wake Up and Make up");
	}

	@BeforeClass
	public void signinAndChangeAttire() {
		System.out.println("signinAndChangeAttire");
	}

	@BeforeMethod
	public void takeOrder() {
		System.out.println("takeOrder");
	}
	
	
	@Test(dataProvider="orderDetails")

	public void cookAndDeliver(String customerName, String tableNo, String orderDish) {

		// System.out.println("cookAndDeliver - 3 " +parameterOne + " Age - "
		// +paramTwo);
		// int size =nullValues.length();
		
		System.out.println(customerName + tableNo + orderDish);

	}
	
	@DataProvider(name="orderDetails")
	public Object[][] getCustomerOrderDetails(){
		
		Object[][] orderDetails = new Object[3][3];
		
		// Customer Name, Table No, Order Details
		
		orderDetails[0][0] = "Prasanth";
		orderDetails[0][1] = "Table T1";
		orderDetails[0][2] = "Medium Size Veg Pizza";
		
		
		orderDetails[1][0] = "Karim";
		orderDetails[1][1] = "Table T2";
		orderDetails[1][2] = "Medium Size Non Veg Pizza";
		
		
		orderDetails[2][0] = "Muthu";
		orderDetails[2][1] = "Table T3";
		orderDetails[2][2] = "Regualr Size Pastha";
		
		
		return orderDetails;
		
	}

	@AfterMethod
	public void cleanTable() {

		System.out.println("cleanTable");
	}

	@AfterClass
	public void signOutAndChangeAttire() {

		System.out.println("signOutAndChangeAttire");
	}

	@AfterTest
	public void closeShop() {

		System.out.println("closeShop");
	}

	@AfterSuite
	public void refreshAndSleep() {

		System.out.println("refreshAndSleep");
	}

}
