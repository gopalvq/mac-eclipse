package mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class IEDriverDemo {

	public static void main(String[] args) {
		//download IEDriver at www.seleniumhq.org/download
		//or from the link: selenium-release.storage.googleapis.com/index.html
		
		//You can also add file path to path in environment variables
		String baseURL = "http://www.yelp.com";
		WebDriver driver;
		
		System.setProperty("webdriver.ie.driver", "/Users/Venu/Desktop/Selenium/ChromeDriver/IEDriverServer.exe");
		
		driver = new InternetExplorerDriver();
		driver.get(baseURL);
		
	}

}
