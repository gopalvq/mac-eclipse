package testngpackage;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;	
 
public class Headless {				
		public static void main(String[] args) {
        	        //File file = new File("C:/Program Files/phantomjs-2.0.0-windows/bin/phantomjs.exe");	
        	        //File file = new File("//usr//local//lib//node_modules//phantomjs//lib//phantom//bin//phantomjs");
                    File file = new File("//Users//Venu//Desktop//Selenium//PhantomJS//phantomjs-2.1.1-macosx//bin//phantomjs");
        	        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
                    WebDriver driver = new PhantomJSDriver();	
                    driver.get("http://www.google.com");         
                    WebElement element = driver.findElement(By.name("q"));	
                    element.sendKeys("Guru99");					
                    element.submit();         			
                    System.out.println("Page title is: " + driver.getTitle());		
                    driver.quit();			
           }		
}
