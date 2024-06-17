package seleintroduction;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class base {
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);   --- THIS IS DEPRICATED NOW
		//explicit wait
				WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
				
		// Note : Fluent wait and Webdriver wait are 2 different Classes of explicit wait (Fluent wait - waits for polling secs given, were as webdriver wait is for continuously monitoring)	
		//expected multiple names define
		String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot","Carrot"};
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Thread.sleep(3000);
		addItems(driver,itemsNeeded);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());	
	}
	public static void addItems(WebDriver driver,String[] itemsNeeded)
	{
		int j=0;
		List<WebElement> products=driver.findElements(By.cssSelector("h4.product-name"));
		for(int i=0;i<products.size();i++)
		{
			String[] name = products.get(i).getText().split("-");
			String formattedName =name[0].trim();
			//trim name of veggies from list
			//Check if name expected by us is present in array or not
			//Covert array to arrylist
			List itemsNeededList = Arrays.asList(itemsNeeded);
			if (itemsNeededList.contains(formattedName))
			{
				j++;
				//Click on Add to cart
			driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
			if(j==itemsNeeded.length)
			{
				break;
			}
			}
		}
	}
}
