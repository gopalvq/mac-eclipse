package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.webdriven.commands.Click;

public class testing {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		String baseurl = "https://massanf.taleo.net/careersection/ex/jobsearch.ftl";
		driver.get(baseurl);
		
		driver.findElement(By.id("topNavInterface.loginAction")).click();
				
		driver.findElement(By.name("loginfield")).sendKeys("venu");
		driver.findElement(By.name("password")).sendKeys("password");
		
		driver.findElement(By.name("loginbutton")).click();

	}

}
