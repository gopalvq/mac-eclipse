package mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariDriverDemo {

	public static void main(String[] args) throws InterruptedException {
		//https://github.com/SeleniumHQ/selenium/wiki/SafariDriver
		
		String baseURL = "http://www.yelp.com";
		WebDriver driver;
		
		driver = new SafariDriver();
		driver.get(baseURL);
		Thread.sleep(3000);
		driver.quit();
	}

}
