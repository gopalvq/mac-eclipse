package mypackage;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
 
public class Forloop {
 
    public static void main(String[] args) {
        
        // launch Firefox and direct it to the Base URL
        for (int i=0; i<2; i++)
        {
        	// declaration and instantiation of objects/variables    
        	WebDriver driver = new FirefoxDriver();
            String baseUrl = "https://www.youtube.com/watch?v=7WiPGP_0AUA";
            String expectedTitle = "Learn Java Tutorial for Beginners, Part 1: A Hello World Program - YouTube";
            String actualTitle = "";
            
        driver.get(baseUrl);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
        
        String url = driver.getCurrentUrl();
        System.out.println("URL of the page is: "+url);
 
        // get the actual value of the title
        actualTitle = driver.getTitle();
        System.out.println("Title of the page is: " +actualTitle);
        driver.findElement(By.className("yt-uix-button yt-uix-button-size-default yt-uix-button-opacity yt-uix-button-has-icon no-icon-markup like-button-renderer-like-button like-button-renderer-like-button-unclicked yt-uix-clickcard-target   yt-uix-tooltip")).click();
 
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Page title verfied & Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        //close Firefox
        //driver.close();
        
        // exit the program explicitly
        //System.exit(0);
        }
    }
 
}