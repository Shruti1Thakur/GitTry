package APINew;

import org.testng.Assert;

import datafiles.Payload1;
import io.restassured.path.json.JsonPath;

public class ComplexJson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JsonPath js=new JsonPath(Payload1.CoursePrice()); // mention jsonpath and pull payload from datafiles
		
		//Print no of cources returned by API
		int count=js.getInt("courses.size()");
		System.out.println(count);
		
		//Print purchase Amount
		int purchaseamount =js.getInt("dashboard.purchaseAmount"); // Parent to child travers for path to print in json
		System.out.println(purchaseamount);
		
		//Print course title
		String coursetitle = js.getString("courses[2].title"); //0th index of course and title
		System.out.println(coursetitle);	
		
		//Print all courses in Json (Dynamic Array) 
		for(int i=0;i<count;i++)
		{
			String allcourses=js.get("courses["+i+"].title");
			int allprices=js.get("courses["+i+"].price");
			System.out.println(allcourses);
			System.out.println(allprices);
		}
		//Print RPA copies without hard coding index
		for(int i=0;i<count;i++)
		{
			String allcourses=js.get("courses["+i+"].title");
			if(allcourses.equalsIgnoreCase("RPA"))
			{
				int copiessolded =js.get("courses["+i+"].copies");
				System.out.println(copiessolded);
				break;
			}
		}
		//Validate if purchase amount is equal to sumof copies and price
		int sum=0;
		for(int i=0;i<count;i++)
		{
			int allprices=js.get("courses["+i+"].price");
			int copiessolded =js.get("courses["+i+"].copies");
			int sumresult = allprices * copiessolded;
			System.out.println(sumresult);
			sum=sum+sumresult;
		}
		System.out.println(sum);
		Assert.assertEquals(sum, purchaseamount);
	}

}
