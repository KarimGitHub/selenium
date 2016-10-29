package day7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LearnReflection {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		//Pass Reflection Class Instance
		
		Class<GenericWrappers> cGenericWrapper =  GenericWrappers.class;
		
				
		// Get the methods details from the class Instance
		
		Method[] cMethods =  cGenericWrapper.getDeclaredMethods();
		
		// Iterate through Methods to print name
		
		System.out.println(" Get Decalred Methods");
		
		
		for (Method methoInstance : cMethods) {
			System.out.println(methoInstance.getName());
		}
		
		// To invoke methods at run time create object of that class
		
		Object objGenericWrapper = cGenericWrapper.newInstance();
		
		for (Method methoInstance : cMethods) {
			
			if(methoInstance.getName().equalsIgnoreCase("getName")){
				
				methoInstance.invoke(objGenericWrapper);
			}
			
			else if(methoInstance.getName().equalsIgnoreCase("setName")){
				methoInstance.invoke(objGenericWrapper, " Selenium ");
			}
		}
		
	}

}
