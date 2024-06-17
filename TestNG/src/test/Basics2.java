package test;
import org.testng.annotations.*;

public class Basics2 {

	@AfterTest   // Usually used to delete the cookies at last of test
	public void Demo() 
	{
		System.out.println("After last annotation");
	}
	@BeforeTest  // this is used to validate 1st. Pre-requist Example - clean DB //or start appinum we need server 1st
	
	public void Demo1() 
	{
		System.out.println("MaytoValidateBeforeAnnotation");
	}
	@AfterSuite
	public void TabLogin() 
	{
		//TAB device Automation
		System.out.println("AfterSUITELast of SUite");

	}

}
