package test;

import org.testng.annotations.Test;

public class TestNGBasics {

	//public static void main(String[] args) {
		// TODO Auto-generated method stub
		//TestNG is acting like a Java complier
	
	
		@Test
		public void Demo() 
		{
			System.out.println("Hello");
		}
		@Test(groups= {"SmokeTest"})
		public void SecondDemo() 
		{
			System.out.println("June");
		}
		
		
	

}
