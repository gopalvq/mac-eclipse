package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByCSSP1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		driver = new FirefoxDriver();
		String baseURL = "http://www.yelp.com";
		driver.get(baseURL);
		
		// '#' - id and "." - class
		driver.findElement(By.cssSelector("#find_desc")).sendKeys("pizza");
		driver.findElement(By.cssSelector("#header-search-submit")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.cssSelector("input#find_desc")).clear();
		driver.findElement(By.cssSelector("input#find_desc")).sendKeys("steak");
		driver.findElement(By.cssSelector("input#header-search-submit")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		driver.findElement(By.cssSelector("input[id=find_desc]")).clear();
		driver.findElement(By.cssSelector("input[id=find_desc]")).sendKeys("steak");
		driver.findElement(By.cssSelector("input[id=header-search-submit]")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		

	}

}
