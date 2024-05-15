package seleintroduction;
import java.util.ArrayList;

public class CoreJavabrushup 
{
	public static void main(String[] args) 
	{
		int MyNum = 5;
		String name = "Shruti Thakur";
		double Dep = 6.22;
		boolean MyCard = true;
		System.out.println("My name is "+ name);
		
		//Arrays - to store multiple values
		
		int[] arr=new int[5];
		arr[0] = 19;
		arr[1] = 27;
		arr[2] = 80;
		arr[3] = 105;
		arr[4] = 567;
		
		// or int[] arr2 ={1,2,34,45,56};
		System.out.println(arr[2]);
		// Loops
		for(int i=0;i<arr.length; i++)
		{
			if (arr[i] %2 ==0)
			{
				System.out.println(arr[i]);
			//break;
			}
			else	
			{
				System.out.println(arr[i] +" is not multiple of 2");
			}
		}
	}	
	    // if we have to access the method of the class, we need to create the object of the class
	 	ArrayList<String> a = new ArrayList<String>();
		    //a.add
	 	
	 		String s1 = "AjioAuto";
	 		String s2 = "Welcome";
	 		{
	 		String s = "Shruti Thakur Learning";
	 		String [] splittedString = s.split("");
	 		
	 		System.out.println(splittedString[0]);
	 		System.out.println(splittedString[1]);
	 		System.out.println(splittedString[2]);
	 		}
	 		
	 		
}


