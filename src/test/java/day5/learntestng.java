package day5;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class learntestng {
 @BeforeSuite
	public void Beforesuite() {
	 System.out.println("**before suite**");
	}
@BeforeTest	
 public void Beforetest(){
	 System.out.println("**before test**");
}
	 @org.testng.annotations.BeforeClass
	 public void Beforeclass()
	 {
		 System.out.println("**before class**");
	 
	 }
	 @BeforeMethod
	 public void Beforemethod()
	 {
		 System.out.println("**before method**");
	 
	 }
	 @Test(dataProvider="sim")
	 public void simple(String a, String b)
	 {
		 System.out.println("**simple test1**"+a +b);
	 
	 }
	 
	 
	 @DataProvider(name="sim")
	 public Object[][] call ()
	 {
		Object Obj[][] = new Object[2][2];
		
		Obj[0][0]="jaffer";
		Obj[0][1]="hemanth";
		
		
		Obj[1][0]="musthak";
		Obj[1][1]="murali";
		return Obj;
		
		
	 
	 }
	 @AfterMethod
	 public void Aftermethod()
	 {
		 System.out.println("**after method**");
	 
	 }
	 @AfterSuite
		public void Aftersuite() 
	 {
		 System.out.println("**after suite**");
		}
	@AfterTest	
	 public void Aftertest()
	{
		 System.out.println("**after test**");
	}
		 @org.testng.annotations.AfterClass
		 public void Afterclass()
		 {
			 System.out.println("**after class**");
		 
		 }
	 
	 
 }

