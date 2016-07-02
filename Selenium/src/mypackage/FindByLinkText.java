package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByLinkText {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new FirefoxDriver();
		String baseURL = "http://www.baltechglobal.com/";
		
		driver.get(baseURL);
		driver.findElement(By.linkText("About Us")).click();
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		
		driver.findElement(By.partialLinkText("Contact")).click();
		System.out.println(driver.getTitle());
		driver.quit();

	}

}
