package day2;

public class LearnBasicJava {

	String name = "Prasanth";
	
	

	public static  void main(String[] args) {

		// Creating object - new
		// ClassName obj = new ClassName();
		//LearnBasicJava learnJava = new LearnBasicJava();
		//learnJava.getName();

		//Holidays holidays = new Holidays();
		
		//int age = 15;
		
		String age_ = "15";
		
		Integer age = 15;
		
	//	String print = age_+age;
		
		int a = Integer.parseInt(age_);
		
		
		int  print = a+age;
		
		System.out.println(print);

		
		
	}

	// access modifier return type method Name() -> body
	public void setName(String namePrint) {

		Holidays holiday = getName();
		System.out.println(holiday.protectedHolidays);

	}

	public Holidays getName() {

		System.out.println(name);
		System.out.println(this.name);

		setName("testing");

		return new Holidays();

	}

	 

}
