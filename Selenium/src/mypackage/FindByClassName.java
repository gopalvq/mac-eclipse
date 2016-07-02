package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindByClassName {

	public static void main(String[] args) throws InterruptedException {
		try{
			WebDriver driver;
			driver = new FirefoxDriver();
			String baseURL = "http://www.baltechglobal.com/";
			driver.get(baseURL);
			
			driver.findElement(By.className("style46")).click();
			System.out.println(driver.getTitle());
			Thread.sleep(3000);
			
			driver.findElement(By.className("style46")).click();
			System.out.println(driver.getTitle());
			driver.quit();
		}
		
		finally{
			System.out.println("Finally block is always executed");
			//driver.quit();
		}

	}

}
