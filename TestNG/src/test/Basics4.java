
package test;

import org.testng.annotations.*;

public class Basics4 {

	@Test
	public void WebLoginhome() 
	{
		//Selenium
		System.out.println("WebLoginhome");

	}

	@Test
	public void MobileLoginhome() 
	{
		//Appium
		System.out.println("MobileLoginhome");
	}
	@Test(groups= {"SmokeTest"})
	public void APILoginhome() 
	{
		//RestAPI Automation
		System.out.println("API Loginhome");

	}
	
	@BeforeMethod
	public void Beforeeveryclass() 
	{
		//RestAPI Automation
		System.out.println("I will be executed before all meathods in in this classthis");

	}
	@AfterMethod
	public void Aftereveryclass() 
	{
		//RestAPI Automation
		System.out.println("I will be executed After all meathods in in this classthis");

	}
}
