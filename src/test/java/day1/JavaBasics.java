package day1;
import java.util.ArrayList;
import java.util.List;

public class JavaBasics {

	public static void main(String[] args) {
		JavaBasics obj = new JavaBasics();

		// obj.loopsEx();
		// obj.swichCase("sun");
		obj.wrapperClassesDataTypes();
		breakAndContinue();

	}

	public void loopsEx() {

		// print numbers from 1 to 10
		for (int i = 0; i < 10; i++) {
			System.out.println("Normal for loop :: " + i);
		}

		List<String> names = new ArrayList<String>();

		names.add("Karim");
		names.add("Kadhar");
		names.add("Babu");
		names.add("Sakthi");

		for (String list : names) {
			System.out.println("Foreach loop for collection :: " + list + names.size());
		}

		for (int i = 0; i < names.size(); i++) {

			System.out.println("for loop for collection ::  " + names.get(i));

		}

		/*
		 * while(true){ System.out.println("I am infinite"); }
		 */

		boolean isMyLunchOver = false;
		while (isMyLunchOver) {

			System.out.println(" Serve food ");

		}

		do {
			System.out.println("Please enter your PIN ");
		} while (false);

	}

	public static void breakAndContinue() {
		for (int i = 0; i < 5; i++) {
			if (i == 3) {
				System.out.println(" Sorry you login attempt exceed the max count  " + i);
				// break;
			}
			System.out.println(" Sorry you login is not successfully for attempt " + i);
		}

	}

	public void swichCase(String day) {
		switch (day) {
		case "SUN":
			System.out.println("Sun day");
			break;
		case "MON":
			System.out.println("Mon day");
			break;
		default:
			System.out.println("Sorry Invalid Entry");
		}

	}

	public void wrapperClassesDataTypes() {

		Integer a = 10;
		System.out.println(Integer.toBinaryString(a));
		// Change String to int
		int parseInt = Integer.parseInt("100");
		int result = parseInt + 10;
		System.out.println(" Using Integer ParseInt -" + result);
		String aa = "100";
		// result = aa+10;
		System.out.println(" Using string - " + aa + 10);
		System.out.println(Integer.MAX_VALUE);
		// Type case Int to String
		String strInt = Integer.toString(10);
		String rp = strInt + "Rp";
		System.out.println(rp);
	}

}
