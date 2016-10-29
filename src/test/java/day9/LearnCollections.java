package day9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LearnCollections {

	public static void main(String[] args) {

		LearnCollections obj = new LearnCollections();

		// obj.learnList();

		 obj.learnSet();

//		obj.learnMap();

	}

	public void learnList() {
		System.out.println(" Learn List");

		List<String> courseDetails = new ArrayList<String>();
		courseDetails.add("Selenium");
		courseDetails.add("QTP");
		courseDetails.add("Selenium");

		for (String cousers : courseDetails) {

			System.out.println(cousers);

		}
	}

	public void learnSet() {
		System.out.println(" Learn Set");

		Set<String> courseDetails = new TreeSet<String>();
		courseDetails.add("Selenium");
		courseDetails.add("QTP");
		courseDetails.add("Selenium");

		for (String cousers : courseDetails) {

			System.out.println(cousers);

		}
	}

	public void learnMap() {
		System.out.println("Learn Map");

		Map<Integer, String> countryCodes = new HashMap<Integer, String>();

		countryCodes.put(1, "India");
		countryCodes.put(2, "US");
		countryCodes.put(3, "India");
		countryCodes.put(1, "UK");

		for (Map.Entry<Integer, String> entry : countryCodes.entrySet()) {

			System.out.println(" Key is -" + entry.getKey() + " - Vlaues : " + entry.getValue());

		}

	}

}
