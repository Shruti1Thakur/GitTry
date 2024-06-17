package seleintroduction;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class actionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.com/");
		Actions a= new Actions(driver);
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		a.moveToElement(driver.findElement(By.id("nav-search-bar-form"))).doubleClick().keyDown(Keys.SHIFT).sendKeys("hello").build().perform();
		//Move to specific element
		a.moveToElement(move).build().perform();

	}

}
