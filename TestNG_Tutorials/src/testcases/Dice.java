package testcases;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Dice {
	WebDriver driver = new FirefoxDriver();
	
	@Test
	  public void applyDice() throws Exception{
		  	driver.get("http://www.dice.com/");
		  	Thread.sleep(1000);
		  	driver.navigate().refresh();
			//driver.manage().window().maximize();
			//driver.findElement(By.xpath(".//*[@id='newNav']/div/div[1]/div/a")).click();
			//Thread.sleep(1000);
			driver.navigate().refresh();
			
			signIn();
			searchJobs();
			//click sort by date
			//driver.findElement(By.id(".//*[@id='sort-by-date-link']")).click();
			
			//click on first job posting
			System.out.println(driver.findElement(By.xpath(".//*[@id='position0']")).getText());
			driver.findElement(By.xpath(".//*[@id='position0']")).click();
			Thread.sleep(10000);
			//click on Apply now
			if(driver.findElement(By.xpath(".//*[@id='easyApplybtn']")).isEnabled()){
				applyJob();
			}
			else
			{
				driver.findElement(By.xpath(".//*[@id='searchBackUrl']")).click();
				searchJobs();
			}
	  }
	
	//Sign in
	public void signIn() throws Exception{
		try{
		driver.findElement(By.xpath(".//*[@id='Login_1']")).click();
		driver.findElement(By.xpath(".//*[@id='Email_1']")).sendKeys("vgbd0110@gmail.com");
		driver.findElement(By.xpath(".//*[@id='Password_1']")).sendKeys("balaga123");
		driver.findElement(By.xpath(".//*[@id='LoginBtn_1']")).click();
		Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("Error in signIn() method" + e.getMessage());
			getscreenshot("/Users/Venu/Desktop/Selenium/Screenshots/");
		}
	}
	
	//search for job
	public void searchJobs() throws Exception{
		try{
		driver.findElement(By.xpath(".//*[@id='job']")).clear();
		driver.findElement(By.xpath(".//*[@id='job']")).sendKeys("junior java developer");
		driver.findElement(By.xpath(".//*[@id='location']")).clear();
		driver.findElement(By.xpath(".//*[@id='searchJob']/div/div[3]/input")).click();
		driver.findElement(By.xpath(".//*[@id='myModal']/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("Error in searchJobs() method" + e.getMessage());
			getscreenshot("/Users/Venu/Desktop/Selenium/Screenshots/");
		}
	}
	
	//Apply for job
	public void applyJob() throws Exception{
		try{
		driver.findElement(By.xpath(".//*[@id='easyApplybtn']")).click();  
		Thread.sleep(1000);
		
		Select drpResume = new Select(driver.findElement(By.xpath(".//*[@id='resume-select']")));
		drpResume.selectByIndex(1);
		
		driver.findElement(By.xpath(".//*[@id='submit-btn']"));
		}
		catch(Exception e){
			System.out.println("Error in applyJob() method" + e.getMessage());
			getscreenshot("/Users/Venu/Desktop/Selenium/Screenshots/");
		}
	}
	
	//screenshot
	public void getscreenshot(String picturepath) throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Date date = new Date();
            //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File("/Users/Venu/Desktop/Selenium/Screenshots/screenshot_"+date+".png"));
            //FileUtils.copyFile(scrFile, new File(picturepath+"screenshot_"+date+".png"));        
    }
}
