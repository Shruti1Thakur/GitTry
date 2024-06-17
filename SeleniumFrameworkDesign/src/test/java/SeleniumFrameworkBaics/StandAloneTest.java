package SeleniumFrameworkBaics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//INitialize driver
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		//Add wait for page to load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//Hit url and login
		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("shruti1.thakur@ril.com");
		driver.findElement(By.id("userPassword")).sendKeys("Suits@3004");
		driver.findElement(By.id("login")).click();
		//On main screen locate items present and add 2 the items in cart
		
		List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait wait2=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait2.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		WebElement prod2=products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		prod2.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		
		driver.findElement(By.cssSelector(".btn.btn-custom[routerlink='/dashboard/cart']")).click();
		
		//Now on cart screen validate number of items added and click on checkout
		List <WebElement> cartProducts=driver.findElements(By.cssSelector(".cartSection h3"));
		Boolean match=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(match);
		Boolean match1=cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		Assert.assertTrue(match1);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		//On Checkout click on payments details and proceed
		Actions a=new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//body//app-root//button[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmmesage=driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmmesage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.quit();
	}

}
