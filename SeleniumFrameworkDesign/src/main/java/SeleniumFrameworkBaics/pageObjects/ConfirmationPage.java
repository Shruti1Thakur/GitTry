package SeleniumFrameworkBaics.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import SeleniumFrameworkDesign.AbstractComponents.AbstractComponent;

public class ConfirmationPage extends AbstractComponent {
	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy (css=".hero-primary")
	WebElement confirmationMessage;
	
	public String getConfirmationPage()
	{
		return confirmationMessage.getText();
	}
	
	
	//String confirmmesage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	//Assert.assertTrue(confirmmesage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
}
