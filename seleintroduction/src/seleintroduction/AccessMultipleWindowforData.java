package seleintroduction;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class AccessMultipleWindowforData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		//Switch Windows
		
		driver.switchTo().newWindow(WindowType.TAB); // If for seperate window use WINDOW
		Set<String> handles = driver.getWindowHandles();
		Iterator <String> it=handles.iterator();
		String parentwindowID =it.next();
		String childwindowID =it.next();
		driver.switchTo().window(childwindowID);
		driver.get("https://rahulshettyacademy.com");
		String coursename = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		driver.switchTo().window(parentwindowID);
		
		//CaptureWebelement SS
		
		WebElement name = driver.findElement(By.cssSelector("[name='name']"));
		name.sendKeys(coursename);
		File file = name.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("logo.png"));
		
		//Get Height and Width of element
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		driver.quit();
	}

}
