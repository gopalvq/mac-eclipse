package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;

public class Tagname {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		String baseUrl = "http://www.facebook.com";
		String tagName = "";
		
		driver.get(baseUrl);
		tagName = driver.findElement(By.id("email")).getTagName();
		System.out.println("Tag name is: "+tagName);
		
		driver.close();
		System.exit(0);
		

	}

}
