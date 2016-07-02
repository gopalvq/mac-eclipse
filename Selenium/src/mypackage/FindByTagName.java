package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByTagName {

	public static void main(String[] args) {
		WebDriver driver;
		driver = new FirefoxDriver();
		String baseURL = "http://www.baltechglobal.com/";
		driver.get(baseURL);
		
		driver.findElement(By.tagName("a")).click();
		System.out.println(driver.getTitle());
		//driver.quit();

	}

}
