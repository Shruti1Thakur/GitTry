
package SeleniumFrameworkBaics.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class Landingpage extends AbstractComponent {
	WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		//Initialising code 
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//WebElement userEmail= driver.findElement(By.id("userEmail"));
	//PageFactory    ---- This is the 
	@FindBy(id="userEmail")
	WebElement userEmail;
	@FindBy(id="userPassword")
	WebElement passwordEle;
	@FindBy(id="login")
	WebElement submit;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public ProductCatelogue loginApplication(String email, String password) {
		
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
		ProductCatelogue productCatatlogue = new ProductCatelogue(driver);
		return productCatatlogue;
		// TODO Auto-generated method stub
		
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
		
		
	}

	//.ng-tns-c4-5.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
}
