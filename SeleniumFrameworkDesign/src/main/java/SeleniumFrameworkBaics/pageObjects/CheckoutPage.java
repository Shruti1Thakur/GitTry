package SeleniumFrameworkBaics.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"India").build().perform();
	@FindBy (css="[placeholder='Select Country']")
	WebElement country;
	//driver.findElement(By.cssSelector(".action__submit")).click();
	@FindBy (css=".action__submit")
	WebElement submit;
	//driver.findElement(By.xpath("//body//app-root//button[2]")).click();
	@FindBy (xpath="//body//app-root//button[2]")
	WebElement selectCountry;
	By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(country,countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	public ConfirmationPage submitOrder()
	{
		//driver.findElement(By.cssSelector(".action__submit")).click();
		submit.click();
		return new ConfirmationPage(driver);

	}


}
