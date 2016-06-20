package mypackage;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class SwitchFrame {
 
	static WebDriver driver;
	
    public static void main(String[] args) throws Exception {
    	driver = new FirefoxDriver();
 
        driver.get("http://selenium.googlecode.com/svn/trunk/docs/api/java/index.html");
        driver.switchTo().frame("classFrame");
        driver.findElement(By.linkText("Deprecated")).click();
        getscreenshot();
        
        
    }
        
        public static void getscreenshot() throws Exception
        {
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                Date date = new Date();
             //The below method will save the screen shot in d drive with name "screenshot.png"
                FileUtils.copyFile(scrFile, new File("/Users/Venu/Desktop/Selenium/Screenshots/screenshot_"+date+".png"));
        }
        
        //driver.quit();
       
}
