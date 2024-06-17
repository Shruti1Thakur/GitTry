package SeleniumFrameworkBaics;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import SeleniumFrameworkBaics.TestComponents.BaseTest;
import SeleniumFrameworkBaics.pageObjects.CartPage;
import SeleniumFrameworkBaics.pageObjects.CheckoutPage;
import SeleniumFrameworkBaics.pageObjects.ConfirmationPage;
import SeleniumFrameworkBaics.pageObjects.ProductCatelogue;

public class SubmitOrderTest extends BaseTest {
	
	@Test(dataProvider="getData")
	public void submitOrder(HashMap <String,String> input) throws IOException, InterruptedException
	{
		//String productName ="ZARA COAT 3";
		ProductCatelogue productCatatlogue = landingpage.loginApplication(input.get("email"), input.get("password"));
		List<WebElement> products= productCatatlogue.getProductList();
		productCatatlogue.addProductToCart(input.get("productname"));
		CartPage cartPage=productCatatlogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay(input.get("productname"));
		Assert.assertTrue(match);
		CheckoutPage checkoutPage=cartPage.goToCheckout();
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage=checkoutPage.submitOrder();
		String confirmmesage=confirmationPage.getConfirmationPage();
		Assert.assertTrue(confirmmesage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//SeleniumFrameworkBaics//Data//PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
	}

}











//@Test(dependsOnMethods= {"submitOrder"})
//public void OrderHistoryTest()
//{
//	//validate order history here and create separate class
//}
//HashMap <String,String> map=new HashMap<String,String>();
//map.put("email", "shruti1.thakur@ril.com");
//map.put("password", "Suits@3004");
//map.put("productname", "ZARA COAT 3");
//
//HashMap <String,String> map1=new HashMap<String,String>();
//map1.put("email", "shruti11.thakur@ril.com");
//map1.put("password", "Suits@3004");
//map1.put("productname", "ZARA COAT 3");