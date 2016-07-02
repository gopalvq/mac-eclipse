package mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverDemo {

	public static void main(String[] args) {
		
		//download chromedriver at http://chromedriver.storage.googleapis.com/index.html
		
		//You can also add file path to path in environment variables
		String baseURL = "http://www.yelp.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "/Users/Venu/Desktop/Selenium/ChromeDriver/chromedriver");
		
		driver = new ChromeDriver();
		
		driver.get(baseURL);

	}

}
