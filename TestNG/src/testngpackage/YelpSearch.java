package testngpackage;

import java.io.IOException;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.naming.NamingException;
import javax.naming.directory.NoSuchAttributeException;
import javax.naming.directory.SearchResult;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import testngpackage.ExcelLib;

public class YelpSearch{
	static WebDriver driver = new FirefoxDriver();
	Logger log = Logger.getLogger("devpinoyLogger");
	ExcelLib neighborhoodData = new ExcelLib("//Users//Venu//Documents//workspace//TestNG//TestData//Workbookxlsformat.xls");
	ExcelLib searchData = new ExcelLib("//Users//Venu//Documents//workspace//TestNG//TestData//searchData.xls");
	
	@BeforeTest
	public void homepage() throws Exception{
		log.debug("Navigating to yelp.com...");
		try{
		driver.get("http://www.yelp.com/boston");
		//driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Assert.assertTrue(driver.getTitle().contains("Boston Restaurants, Dentists, Bars, Beauty Salons, Doctors"));
		getscreenshot("/Users/Venu/Desktop/Selenium/Screenshots/");
		//getscreenshot("./Screenshots/");
		//getscreenshot(null);
	
		}catch(Exception e){
			System.out.println("Error in homepage method" + e.getMessage());
			getscreenshot("/Users/Venu/Desktop/Selenium/Screenshots/");
		}
	}
	
	@Test(priority = 0)
	public void search() throws Exception{
		try{
		//search for terms given in datasheet 'searchData.xls'
				for(int row=1; row<searchData.rowCount(); row++){
					System.out.println(searchData.GetCellValue1("Search_Key", row));
					searchRestaurants(searchData.GetCellValue1("Search_Key", row));
					getscreenshot("/Users/Venu/Desktop/Selenium/Screenshots/");
					countsearchresults();
				}
				//click All Filters button
				driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[6]/label/span")).click();
				Thread.sleep(1000);
		}catch(Exception e){
			System.out.println("Error in search method" + e.getMessage());
			getscreenshot("/Users/Venu/Desktop/Selenium/Screenshots/");
		}
	}
	
	@Test(priority = 1)
	public void filters() throws Exception{
		try{
		//Select neighborhood checkboxes given in datasheet 'Workbookxlsformat.xls'
		List<WebElement> chkNeighborhood = driver.findElements(By.xpath(".//*[@id='wrap']/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2][@class='filter-set place-filters']/ul[1]/li"));
		System.out.println("No. of neighborhood checkboxes availabe: " +chkNeighborhood.size());
		for(int i=1; i<=chkNeighborhood.size(); i++)
		{
			Thread.sleep(1000);
			WebElement neighborhood = driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/ul[1]/li["+ i +"]/label/span"));
			System.out.println("Neighborhood checkbox: " + neighborhood.getText());
			String neighborhoodName = neighborhood.getText();
			
			for(int j=1; j<neighborhoodData.rowCount(); j++){
			
			if(neighborhoodName.equalsIgnoreCase(neighborhoodData.GetCellValue1("Neighborhood", j))){
				neighborhood.click();
				Thread.sleep(2000);
				countsearchresults();
				getRatings();
				showFirstresultdetails();
				search();
			}
			else{
				continue;
			}
			}
			
		}
		}catch(Exception e){
			System.out.println("Error in filters method" + e.getMessage());
			getscreenshot("/Users/Venu/Desktop/Selenium/Screenshots/");
		}
	}

	//@Test(priority = 2)
	public void getRatings() throws Exception{
			log.debug("Getting rating stars for search results on first page...");
			try{
			//First search result
			String rating = driver.findElement(By.xpath(".//*[@id='super-container']/div/div[2]/div[1]/div/div[4]/ul[2]/li[3]/div/div[1]/div[1]/div/div[2]/div[1]/div/i/img")).getAttribute("alt");
			System.out.println(rating);
			log.debug("Rating for first search result: " + rating);
			
			//Second search result
			String rating1 = driver.findElement(By.xpath(".//*[@id='super-container']/div/div[2]/div[1]/div/div[4]/ul[2]/li[4]/div/div[1]/div[1]/div/div[2]/div[1]/div/i/img")).getAttribute("alt");
			System.out.println(rating1);
			log.debug("Rating for second search result: " + rating1);
			
			//Third search result
			String rating2 = driver.findElement(By.xpath(".//*[@id='super-container']/div/div[2]/div[1]/div/div[4]/ul[2]/li[5]/div/div[1]/div[1]/div/div[2]/div[1]/div/i/img")).getAttribute("alt");
			System.out.println(rating2);
			log.debug("Rating for third search result: " + rating2);
			
			//Fourth search result
			String rating3 = driver.findElement(By.xpath(".//*[@id='super-container']/div/div[2]/div[1]/div/div[4]/ul[2]/li[6]/div/div[1]/div[1]/div/div[2]/div[1]/div/i/img")).getAttribute("alt");
			System.out.println(rating3);
			log.debug("Rating for fourth search result: " + rating3);
			
			//Fifth search result
			String rating4 = driver.findElement(By.xpath(".//*[@id='super-container']/div/div[2]/div[1]/div/div[4]/ul[2]/li[7]/div/div[1]/div[1]/div/div[2]/div[1]/div/i/img")).getAttribute("alt");
			System.out.println(rating4);
			log.debug("Rating for fifth search result: " + rating4);
			}catch(Exception e){
				System.out.println("Error in getRatings method" + e.getMessage());
				getscreenshot("/Users/Venu/Desktop/Selenium/Screenshots/");
			}
			}
	
	//@Test(priority = 3)
	public void showFirstresultdetails() throws Exception{
		log.debug("Clicking first result link...");
		try{
		String firstResult = driver.findElement(By.xpath(".//*[@id='super-container']/div/div[2]/div[1]/div/div[4]/ul[2]/li[3]/div/div[1]/div[1]/div/div[2]/h3/span/a/span")).getText();
		System.out.println("First result business name: " + firstResult);
		driver.findElement(By.xpath(".//*[@id='super-container']/div/div[2]/div[1]/div/div[4]/ul[2]/li[3]/div/div[1]/div[1]/div/div[2]/h3/span/a/span")).click();
		Thread.sleep(2000);
		
		String address = driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div/div[1]/div/div[3]/div[1]/div/div[2]/ul/span/li/strong/address/span[1]")).getText();
		String address1 = driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div/div[1]/div/div[3]/div[1]/div/div[2]/ul/span/li/strong/address/span[2]")).getText();
		String address2 = driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div/div[1]/div/div[3]/div[1]/div/div[2]/ul/span/li/strong/address/span[3]")).getText();
		String address3 = driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div/div[1]/div/div[3]/div[1]/div/div[2]/ul/span/li/strong/address/span[4]")).getText();
		String phoneNumber = driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div/div[1]/div/div[3]/div[1]/div/div[2]/ul/li[3]/span[3]")).getText();
		String website = null;
		List<WebElement> allElements = driver.findElements(By.xpath(""));
		if(allElements.size()==5){
			website = driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div/div[1]/div/div[3]/div[1]/div/div[2]/ul/li[5]/span/div/a")).getText();
		}
		else{
			website = driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div/div[1]/div/div[3]/div[1]/div/div[2]/ul/li[4]/span/div/a")).getText();
		}
		
		System.out.println("First result business Address: " + address+","+address1+" "+address2+ " "+address3);
		log.debug("First result business Address: " + address+","+address1+" "+address2+ " "+address3);
		System.out.println("First result business phone number: "+ phoneNumber);
		log.debug("First result business phone number: " + phoneNumber);
		System.out.println("First result business website: "+"www."+website);
		log.debug("First result business website: " + "www."+website);
		
		String firstReview = driver.findElement(By.xpath(".//*[@id='super-container']/div/div/div[1]/div[1]/div[1]/ul/li[1]/div[2]/p")).getText();
		System.out.println("First Review" +firstReview);
		log.debug("First Review" +firstReview);
		
		String secondReview = driver.findElement(By.xpath(".//*[@id='super-container']/div/div/div[1]/div[1]/div[1]/ul/li[2]/div[2]/p")).getText();
		System.out.println("Second Review" + secondReview);
		log.debug("Second Review" + secondReview);
		
		String thirdReview = driver.findElement(By.xpath(".//*[@id='super-container']/div/div/div[1]/div[1]/div[1]/ul/li[3]/div[2]/p")).getText();
		System.out.println("Third Review" + thirdReview);
		log.debug("Third Review" + thirdReview);
		}catch(Exception e){
			System.out.println("Error in showFirstresultdetails method" + e.getMessage());
			getscreenshot("/Users/Venu/Desktop/Selenium/Screenshots/");
		}
	}
	
	
	//@AfterTest
	public void terminateBrowser(){
		driver.manage().deleteAllCookies();
		driver.quit();
	}
	
	public void searchRestaurants(String search) throws InterruptedException {
		log.debug("Searching...");
		driver.findElement(By.id("find_desc")).clear();
		driver.findElement(By.id("find_desc")).sendKeys(search);
		driver.findElement(By.id("header-search-submit")).click();
		Thread.sleep(2000);
		String searchHeading = driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div[1]/div/div[2]/div/div[1]/h1")).getText();
		System.out.println(searchHeading);
		//driver.findElement(By.id("find_desc")).clear();
		Thread.sleep(1000);
	}
	
	public void countsearchresults(){
		log.debug("Counting search results...");
		String result = driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div[1]/div/div[2]/div/div[1]/span")).getText().split(" ")[3];
		System.out.println("Search results total count: " + result);
		log.debug("Search results total count: " + result);
		String result2 = driver.findElement(By.xpath(".//*[@id='wrap']/div[3]/div[1]/div/div[2]/div/div[1]/span")).getText().split(" ")[1];
		System.out.println("Search results count per page: " + result2);
		log.debug("Search results count per page: " + result2);
	}
	
	public void explicitWait(){
		WebDriverWait myWaitVar = new WebDriverWait(driver, 300);
		myWaitVar.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//*[@id='wrap']/div[3]/div[1]/div/div[2]/div/div[1]/h1")));
	}
	
	public void implicitWait(int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void getscreenshot(String picturepath) throws Exception 
    {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            Date date = new Date();
            //The below method will save the screen shot in d drive with name "screenshot.png"
            FileUtils.copyFile(scrFile, new File("/Users/Venu/Desktop/Selenium/Screenshots/screenshot_"+date+".png"));
            //FileUtils.copyFile(scrFile, new File(picturepath+"screenshot_"+date+".png"));        
    }
	
	public void tearDown(ITestResult result) throws Exception{
		if(ITestResult.FAILURE==result.getStatus()){
			getscreenshot("./Screenshots/");
			
		}
	}
		
}

