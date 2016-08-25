package day6;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
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

	@Test
	@Parameters({ "myName", "age" })

	public void cookAndDeliver(String name, String age) {

		System.out.println("cookAndDeliver - " + name + age);
	}

	@Test
	public void cookAndDeliver1() {

		System.out.println("cookAndDeliver");
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
