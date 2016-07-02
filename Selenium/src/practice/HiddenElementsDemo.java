package practice;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HiddenElementsDemo {
	WebDriver driver;
	String baseUrl1;
	String baseUrl2;

	@Before
	public void test() {
		driver = new FirefoxDriver();
		baseUrl1 = "http://letskodeit.teachable.com/pages/practice";
		baseUrl2 = "http://www.expedia.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	//@Test
	public void testLetsKodeIt() throws InterruptedException{
		driver.get(baseUrl1);
		
		WebElement textBox = driver.findElement(By.id("displayed-text"));
		System.out.println("Text Box Displayed: " + textBox.isDisplayed());
		
		Thread.sleep(2000);
		
		WebElement hideButton = driver.findElement(By.id("hide-textbox"));
		hideButton.click();
		System.out.println("Clicked on hide button");
		System.out.println("Text box Displayed: " +textBox.isDisplayed());
		
		Thread.sleep(2000);
		
		WebElement showButton = driver.findElement(By.id("show-textbox"));
		showButton.click();
		System.out.println("Clicked on show button");
		System.out.println("Text box Displayed: " +textBox.isDisplayed());
	}
	
	@Test
	public void testExpedia(){
		driver.get(baseUrl2);
		
		WebElement childDropdown = driver.findElement(By.id("package-1-age-select-1"));
		System.out.println("Child Drop down displayed: " +childDropdown.isDisplayed());
	}
	
	@After
	public void tearDown() throws InterruptedException{
		Thread.sleep(2000);
		driver.quit();
	}
	
	

}
