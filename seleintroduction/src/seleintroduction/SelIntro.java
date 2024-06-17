package seleintroduction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntro {

	public static void main(String[] args) {
		
		// Invoking Browser
		//Use Chrome - ChromeDriver - Methods
		//Webdriver is interface which has methods and chrome is implemented
		//chromedriver.exe -> will invoke Chrome browser
		//Step to invoke chrome driver or use selenium manager
		
		//System.setProperty("webdriver.chrome.driver", "\\Users\\shruti1.thakur\\Downloads\\chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
		

	}

}
