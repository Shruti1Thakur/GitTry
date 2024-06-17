package seleintroduction;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class SortingwithStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		//click on column, capture all elements in list ,get text of all web elements in new list,on this new list perform sort and create sorted list 
		//compare new original vs sorted list
		
		driver.findElement(By.xpath("//th[@aria-label='Veg/fruit name: activate to sort column ascending']")).click();
		List<WebElement> elements = driver.findElements(By.xpath("//tr/td[1]"));
		List<String> originalList =elements.stream().map(s->s.getText()).collect(Collectors.toList());
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
		Assert.assertTrue(originalList.equals(sortedList));
		
		List<String> price;
		do
		{
		//Get Rice from list and then print its price
		List<WebElement> rows = driver.findElements(By.xpath("//tr/td[1]"));
		price= rows.stream().filter(s->s.getText().contains("Rice")).
		map(s->getPriceVeggies(s)).collect(Collectors.toList());
		price.forEach(a->System.out.println(a));
		if(price.size()<1)
		{
			driver.findElement(By.cssSelector("[aria-label='Next']")).click();
		}
		} while(price.size()<1);
		
	//Searchbox
		driver.findElement(By.id("search-field")).sendKeys("Rice");
		List<WebElement> veggies=driver.findElements(By.xpath("//tr/td[1]"));
		List<WebElement> filteredList=veggies.stream().filter(veggie->veggie.getText().contains("Rice")).collect(Collectors.toList());
		Assert.assertEquals(veggies.size(), filteredList.size());
	
	}

	private static String getPriceVeggies(WebElement s) {
		// TODO Auto-generated method stub
		String pricevalue=s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return pricevalue;
	}
	

	
	
}
