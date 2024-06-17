import java.util.ArrayList;

public class Javastreamone {
	
		//Count of A
	
		public void regular()
		{
			ArrayList<String> names=new ArrayList<String>();
			names.add("Radha");
			names.add("Abhi");
			names.add("Akash");
			names.add("Firan");
			names.add("Juvo");
			int count=0;
			
			for(int i=0;i<names.size();i++)
			{
				String actual = names.get(i);
				if(actual.startsWith("A"))
				{
					count++;
				}
				System.out.println(count);
			}
		}

}
