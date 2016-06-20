package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dice {
	WebDriver driver = new FirefoxDriver();
	
	@Test
	  public void applyDice() throws InterruptedException{
		  	driver.get("http://www.dice.com/");
		  	Thread.sleep(1000);
		  	driver.navigate().refresh();
			//driver.manage().window().maximize();
			//driver.findElement(By.xpath(".//*[@id='newNav']/div/div[1]/div/a")).click();
			//Thread.sleep(1000);
			driver.navigate().refresh();
			
			//Sign in
			driver.findElement(By.xpath(".//*[@id='Login_1']")).click();
			driver.findElement(By.xpath(".//*[@id='Email_1']")).sendKeys("vgbd0110@gmail.com");
			driver.findElement(By.xpath(".//*[@id='Password_1']")).sendKeys("balaga123");
			driver.findElement(By.xpath(".//*[@id='LoginBtn_1']")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath(".//*[@id='job']")).sendKeys("junior java developer");
			driver.findElement(By.xpath(".//*[@id='location']")).clear();
			driver.findElement(By.xpath(".//*[@id='searchJob']/div/div[3]/input")).click();
			driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[1]/button")).click();
			Thread.sleep(1000);
			
			//click sort by date
			//driver.findElement(By.id(".//*[@id='sort-by-date-link']")).click();
			//click on first job posting
			System.out.println(driver.findElement(By.xpath(".//*[@id='position0']")).getText());
			driver.findElement(By.xpath(".//*[@id='position0']")).click();
			Thread.sleep(10000);
			//click on Apply now
			driver.findElement(By.xpath(".//*[@id='easyApplybtn']")).click();  
			Thread.sleep(1000);
			
			Select drpResume = new Select(driver.findElement(By.xpath(".//*[@id='resume-select']")));
			drpResume.selectByIndex(1);
			
			driver.findElement(By.xpath(".//*[@id='submit-btn']"));
			
	  }
}
