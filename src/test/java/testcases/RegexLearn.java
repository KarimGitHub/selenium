package testcases;

public class RegexLearn {
	
	public static void main(String[] args) {
		String text = "Photon info TC1 (10066)";
		
		System.out.println(text.replaceAll("\\D", ""));   
	}

}
