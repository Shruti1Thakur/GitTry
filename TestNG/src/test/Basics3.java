package test;

import org.testng.Assert;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.*;

public class Basics3 {
	

	@BeforeClass
	public void BeforClass() 
	{
		System.out.println("BeforClass Basics3");

	}

	@Test(groups= {"SmokeTest"})
	public void WebLogin() 
	{
		//Selenium
		System.out.println("WebLogin");
		Assert.assertTrue(false);

	}

	@Test
	public void MobileLogin() 
	{
		//Appium
		System.out.println("MobileLogin"); // This we have excluded in xml w
	}
	
	@BeforeSuite
	public void TabLogin() 
	{
		//TAB device Automation
		System.out.println("TAB Login Before SUITE");

	}
	
	
	@Test(dependsOnMethods= {"WebAPILogin"})
	public void APILogin() 
	{
		//RestAPI Automation
		System.out.println("API Login");

	}
	
	//Use data here mentioned below

	@Test(dataProvider="getData")
	public void WebAPILogin(String username,String password) 
	{
		//RestAPI Automation
		System.out.println("WebAPI Login");
		System.out.println(username);
		System.out.println(password);

	}
	@AfterClass
	public void AfterClass() 
	{
		System.out.println("After Basics3");

	}
	@Test(enabled=false) 
	//helper attribute = this will skip this TC.. This used when know issues are there
	public void WebAPILogin222() 
	{
		//RestAPI Automation
		System.out.println("WebAPI222 Login");

	}
	//Also we have timout HELPER ATTRIBUTE.. example timeouts (timeOut=4000)
	@DataProvider
	public Object[][] getData()
	{
		//1st combination user name and password - good credit history
		//2nd combination user name and password- no credit history
		//3rd combination user name and password- Fradulent credit history
		Object[][] data =new Object[3][2];
		data [0][0]="firstusername";
		data [0][1]="password";
		data [1][0]="2ndusername";
		data [1][1]="password";
		data [2][0]="3rdusername";
		data [2][1]="password";
		return data;
	}
}
