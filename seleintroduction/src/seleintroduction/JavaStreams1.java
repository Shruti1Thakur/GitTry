package seleintroduction;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaStreams1 {
		
		//@Test
		public void regular()
			{
				ArrayList<String> names=new ArrayList<String>();
				names.add("Abhijeet");
				names.add("Don");
				names.add("Akash");
				names.add("Adam");
				names.add("Ram");
				int count=0;
				
				for(int i=0;i<names.size();i++)
				{
					String actual = names.get(i);
					if(actual.startsWith("A"))
					{
						count++;
					}
				}
				System.out.println(count);
			}
		//@Test
		public void streamFilter()
		{
			ArrayList<String> names =new ArrayList<String>();
			names.add("Abhijeet");
			names.add("Don");
			names.add("Akash");
			names.add("Adam");
			names.add("Ram");
			//there is no life for intermediate opr if there is no terminal // Terminal operation will execute only if inter op filter returms true
			//we can create stream
			//How to filter in stream api
			
			Long c=names.stream().filter(s->s.startsWith("A")).count();
			System.out.println(c);
			
		long d=	Stream.of("Abhijeet","Done","Abhilash","Adam","Ram").filter(s->
			{
			s.startsWith("A");
			return true;
				
			}).count();
		System.out.println(d);
		
		// Print all the names of arraylist
		
		names.stream().filter(s->s.length()>4).forEach(s->System.out.println(s));
		//Limit only 1 result
		names.stream().filter(s->s.length()>4).limit(1).forEach(s->System.out.println(s));
		}

		//@Test
		public void streamMap()
		{
			//Print names of which has last letter M
			Stream.of("Abhijeet","Done","Abhilash","Adam","Ram").filter(s->s.endsWith("m")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			//print names with 1st letter uppercase and sorted
			List<String> name=Arrays.asList("Abhijeet","Done","Abhilash","Adam","Ram");
			name.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
			List<String> name1=Arrays.asList("Aman","Dupe","Raman","Arjan","Manee");
			Stream<String> newStream = Stream.concat(name.stream(), name1.stream());
			//newStream.sorted().forEach(s->System.out.println(s));
			boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Adam"));
			System.out.println(flag);
			Assert.assertTrue(flag);
			
		}
		
		@Test
		public void streamCollect()
		{
			List<String> ls=Stream.of("Abhijeet","Don","Abhilashya","Adam","Rama").filter(s->s.endsWith("a"))
			.map(s->s.toUpperCase()).collect(Collectors.toList());
			System.out.println(ls.get(0));
			//Print unique numbers in array
			List<Integer>values = Arrays.asList(1,2,3,8,1,2,5,5,9);
			values.stream().distinct().forEach(s->System.out.println(s));
			values.stream().sorted().forEach(s->System.out.println(s));
			List <Integer> li=values.stream().distinct().sorted().collect(Collectors.toList());
			System.out.println(li.get(2));
		}
		
}
