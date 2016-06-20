package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MassCareers {
	
	static String actualtitle;
	static WebDriver driver = new FirefoxDriver();
	
	@Test
	public void homePage() {	
		driver.get("https://stgmassanf.taleo.net/careersection/ex/jobsearch.ftl?lang=en");
		actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		
		driver.findElement(By.linkText("Sign In")).click();
		driver.manage().window().maximize();
	}
	
	@Test(dependsOnMethods={"homePage"})
	public static void privacyAgreement(){
		
		//driver.findElement(By.id("dialogTemplate-dialogForm-StatementBeforeAuthentificationContent-ContinueButton")).click();
		driver.findElement(By.xpath("//html/body/div[2]/div[2]/div[2]/div/div/div/form/span/span/span[2]/span/span/span/input[1]")).click();
		//driver.findElement(By.name("dialogTemplate-dialogForm-StatementBeforeAuthentificationContent-ContinueButton")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String pa_pagetitle = driver.getTitle();
		System.out.println("Login page title: " + pa_pagetitle);
		
	}
	
	@Test(dependsOnMethods={"privacyAgreement"})
	public static void loginPage(){
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/form/span/span/span[2]/span/span[1]/table/tbody/tr[1]/td/input[1]")).sendKeys("venu6");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/form/span/span/span[2]/span/span[1]/table/tbody/tr[1]/td/input[2]")).sendKeys("Tester@123");
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/form/span/span/span[2]/span/span[2]/input[1]")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		String pagetitle = driver.getTitle();
		System.out.println("Page title after login:" + pagetitle);
	}
	
	
}
