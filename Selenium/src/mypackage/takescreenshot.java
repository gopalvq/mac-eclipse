package mypackage;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
    
    public class takescreenshot{
    	static WebDriver driver;
         
      @Test
      public static void openBrowser() throws Exception {
    	  driver = new FirefoxDriver();
    	  driver.manage().window().maximize();
    	  driver.get("https://stgmassanf.taleo.net/careersection/ex/jobsearch.ftl?lang=en");
    	  
    	  try
    	  {
                //the below statement will throw an exception as the element is not found, Catch block will get executed and takes the screenshot.
    		  driver.findElement(By.id("testing")).sendKeys("test");
                 
                   //if we remove the below comment, it will not return exception and screen shot method will not get executed.
    		  //driver.findElement(By.id("gbqfq")).sendKeys("test");
    	  }
    	  
    	  catch (Exception e)
    	  {
    		  System.out.println("I'm in exception");
    		  //calls the method to take the screenshot.
    		  getscreenshot();
     	  }
      }
      
      public static void getscreenshot() throws Exception 
      {
              File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
              Date date = new Date();
           //The below method will save the screen shot in d drive with name "screenshot.png"
              FileUtils.copyFile(scrFile, new File("/Users/Venu/Desktop/Selenium/Screenshots/screenshot_"+date+".png"));
      }
      
      
      
    public static void main(String arg[]) throws Exception{
    	openBrowser();
    	driver.close();
    }
    }
    
