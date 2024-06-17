package seleintroduction;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		//1. find links on page
		//2. count of link of footer section
		//3.count of subsection links in footer section
		//4. check if all the links in that footer subsection is opening
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footdriver=driver.findElement(By.id("gf-BIG"));  // limit the driver scope to get count
		System.out.println(footdriver.findElements(By.tagName("a")).size());
		WebElement cloumndriver=footdriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(cloumndriver.findElements(By.tagName("a")).size());

		for(int i=1;i<cloumndriver.findElements(By.tagName("a")).size();i++)
		{
			
			String clickonlinkTab=Keys.chord(Keys.COMMAND,Keys.ENTER);
			cloumndriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
		}
		Set<String> countwindow = driver.getWindowHandles();
	    Iterator<String> it=countwindow.iterator();
	    while(it.hasNext())
	    {
	    driver.switchTo().window(it.next());
	    System.out.println(driver.getTitle());
	    driver.navigate().back();
		
	    }
	    
	}
}


