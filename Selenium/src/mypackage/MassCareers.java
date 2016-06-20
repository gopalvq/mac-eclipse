package mypackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.thoughtworks.selenium.Wait;

public class MassCareers {
	
	static String actualtitle;
	static WebDriver driver = new FirefoxDriver();
	static String appUrl = "https://stgmassanf.taleo.net/careersection/ex/jobsearch.ftl?lang=en";
	
	public static void main(String[] args) {
		driver.get(appUrl);
		actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		verifyTitle();
		
		driver.findElement(By.linkText("Sign In")).click();
		driver.manage().window().maximize();
		privacyAgreement();
		loginPage();
		//driver.close();
	}
	
	static String expectedtitle = "MassCareers";

	public static void verifyTitle() 
	{
	if (actualtitle.contentEquals(expectedtitle))
		{
				System.out.println("Page title verification passed");
		}
	else
		{
				System.out.println("Page title verification failed");
		}
	}
	
	public static void privacyAgreement(){
		
		//driver.findElement(By.id("dialogTemplate-dialogForm-StatementBeforeAuthentificationContent-ContinueButton")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[2]/div/div/div/form/span/span/span[2]/span/span/span/input[1]")).click();
		//driver.findElement(By.name("dialogTemplate-dialogForm-StatementBeforeAuthentificationContent-ContinueButton")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String pa_pagetitle = driver.getTitle();
		System.out.println("Login page title: " + pa_pagetitle);
		
	}
	
	public static void loginPage(){
		WebElement username = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/form/span/span/span[2]/span/span[1]/table/tbody/tr[1]/td/input[1]"));
		username.clear();
		username.sendKeys("venu6");
		
		WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/form/span/span/span[2]/span/span[1]/table/tbody/tr[1]/td/input[2]"));
		password.clear();
		password.sendKeys("Tester@123");
		
		WebElement signin = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/form/span/span/span[2]/span/span[2]/input[1]"));
		signin.click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String pagetitle = driver.getTitle();
		System.out.println("Page title after login:" + pagetitle);
	}
	
	
	
	

}
