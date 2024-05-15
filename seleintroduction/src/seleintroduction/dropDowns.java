package seleintroduction;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class dropDowns {

	public static void main(String[] args) throws InterruptedException {
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//dropdown with select tag. Here we are selecting dropdown from options present (STATIC)
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);
		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
// Drop downs with adding/increase-decrease parameters
		
		driver.findElement(By.id("divpaxinfo")).click();
			Thread.sleep(2000L);
		
// Loop when same elements to be hit multiple times both example with while and one with For
			//			int i =1;
			//		while(i<5)
			//		{
			//			driver.findElement(By.id("hrefIncAdt")).click();
			//			i++;
			//		}
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}	
		driver.findElement(By.id("btnclosepaxoption")).click();
		Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		
// Dropdown with dynamic other dropdown Dynamic dropdown
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
		driver.findElement(By.xpath("//a[@value='MAA']")).click();
		Thread.sleep(2000);
		
		
//Calender selection
		
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-hover")).click();
		
		//check round trip radio button
		
		//DO NOT USE  As it doest work with many browsers -- System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
//		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));
//		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
//		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		//DO NOT USE  As it doest work with many browsers -- System.out.println(driver.findElement(By.name("ctl00$mainContent$view_date2")).isEnabled());
//		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
//		{
//			System.out.println("Its Enabled");
//			Assert.assertTrue(true);
//		}
//		else
//		{
//			Assert.assertTrue(false);
//		}
//		
		
			

		//driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();
		//driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']")).click();
		//driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active")).click();
		
// Suggestive xpath example
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		Thread.sleep(3000);
		List<WebElement> options =driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
		for(WebElement option :options)
		{
		if(option.getText().equalsIgnoreCase("India"))
		{
		option.click();

		break;
		}
		}
		
//Checkbox example
		
		
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		

//Find all checkboxes on page
		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
//Search the desired flight
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		
		

		//driver.close();
		
		
		

	}

}
