package seleintroduction;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;


public class Misllanious {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
//driver.manage().deleteCookieNamed("session key"); //Syntax delete that specific session cookie
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("/Users/shruti1.thakur/eclipse-workspace/seleintroduction/shruti/screeshot.png"));
	
		
//Validate Broken link(URL) for all links on page
	      List<WebElement> links=   driver.findElements(By.cssSelector("li[class='gf-li'] a"));
	      SoftAssert a =new SoftAssert();
	      for(WebElement link : links)
	      {
	          String url= link.getAttribute("href");
	          HttpURLConnection   conn= (HttpURLConnection)new URL(url).openConnection();
	          conn.setRequestMethod("HEAD");
	          conn.connect();
	          int respCode = conn.getResponseCode();
	          System.out.println(respCode);
	          a.assertTrue(respCode<400, "The link with Text"+link.getText()+" is broken with code" +respCode);
	      }
	      a.assertAll();
		driver.quit();

	}

}
