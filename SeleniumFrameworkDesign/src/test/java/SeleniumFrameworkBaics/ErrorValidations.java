package SeleniumFrameworkBaics;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import SeleniumFrameworkBaics.TestComponents.BaseTest;
import SeleniumFrameworkBaics.pageObjects.CartPage;
import SeleniumFrameworkBaics.pageObjects.CheckoutPage;
import SeleniumFrameworkBaics.pageObjects.ConfirmationPage;
import SeleniumFrameworkBaics.pageObjects.ProductCatelogue;

public class ErrorValidations extends BaseTest {

	@Test
	public void LoginErrorValidation() throws IOException, InterruptedException
	{
		String productName ="ZARA COAT 3";
		landingpage.loginApplication("shruti1.thakur@ril.com", "Suits@3009");
		AssertJUnit.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
	}
	
	@Test
	public void submitOrder() throws IOException, InterruptedException
	{
		String productName ="ZARA COAT 3";
		ProductCatelogue productCatatlogue = landingpage.loginApplication("shruti1.thakur@ril.com", "Suits@3004");
		List<WebElement> products= productCatatlogue.getProductList();
		productCatatlogue.addProductToCart(productName);
		CartPage cartPage=productCatatlogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
		
	}

}
