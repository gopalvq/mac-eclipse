package mypackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class YelpSearch {
	static WebDriver driver = new FirefoxDriver();
	
	public static void main(String[] args){
		
		driver.get("http://www.yelp.com");
		driver.manage().window().maximize();
		
		//searchRestaurants();
		searchRestaurantspizza();
		implicitWait(30);
		explicitWait();
		countsearchresults();
		
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[6]/label/span")).click();
	
		selectFilters();
		explicitWait();	
		countsearchresults();
		
		explicitWait();
		//getStarrating();
		clickFirstresult();
		
	}
	
	
	
	
	public static void searchRestaurants(){
		driver.findElement(By.id("find_desc")).sendKeys("Restaurants");
		driver.findElement(By.id("header-search-submit")).click();
		
	}
	
	public static void searchRestaurantspizza(){
		driver.findElement(By.id("find_desc")).clear();
		
		driver.findElement(By.id("find_desc")).sendKeys("Restaurants pizza");
		driver.findElement(By.id("header-search-submit")).click();
		
		
		
	}
	
	public static void countsearchresults(){
		String result = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div/div[1]/span")).getText().split(" ")[3];
		System.out.println("Restaurants+Pizza search results count: " + result);
		
		String result2 = driver.findElement(By.className("pagination-results-window")).getText().split(" ")[1];
		System.out.println("Restaurants+Pizza search results count per page: " + result2);
	}
	
	public static void explicitWait(){
		WebDriverWait myWaitVar = new WebDriverWait(driver, 60);
		myWaitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div/div[2]/div[1]/ul/li[6]/label/span")));
		
	}
	
	public static void implicitWait(int time){
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void selectFilters(){
/*		WebElement chkNeighborhoods = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/ul[1]/li[1]/label"));
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		if(!chkNeighborhoods.isSelected())
		{
			chkNeighborhoods.click();
		}*/
		
		int length = driver.findElements(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/h4")).size();
		 WebDriverWait wait = new WebDriverWait(driver,60);
		 for (int i = 0; i < length; i++) {
		    WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(driver.findElements(By.xpath("/html/body/div[2]/div[3]/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/ul[1]/li[3]/label")).get(i)));
		      if (!ele.isSelected())
		           ele.click();
		 }
		
		
/*		Select drpSearch = new Select(driver.findElement(By.id("find_desc")));
		drpSearch.selectByValue("Restaurants");
*/		
		
	}
	
	public static void getStarrating(){
		
		//String rating = driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div[2]/div[1]/div/div[4]/ul[2]/li[3]/div/div[1]/div[1]/div/div[2]/div[1]/div/i")).getText();
		
		String rating = driver.findElement(By.className("biz-rating biz-rating-large clearfix")).getText();
		System.out.println(rating);
		
	}
	
	public static void clickFirstresult(){
		//driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[2]/div/div[2]/div[1]/div/div[4]/ul[2]/li[3]/div/div[1]/div[1]/div/div[2]/h3/span/a/span")).click();
		//driver.findElement(By.id("jVjZK3MWODpF2fsmAnswgw")).click();
		//String firstresult = driver.findElement(By.xpath("//*[@class='indexed-biz-name']//*[text()='1.']")).getText();
		
		String firstresult = driver.findElement(By.xpath(".//*[@id='super-container']/div/div[2]/div[1]/div/div[4]/ul[2]/li[3]/div/div[1]/div[1]/div/div[2]/h3/span/a/span")).getText();
		System.out.println(firstresult);
		//driver.findElement(By.xpath("//*[@class='indexed-biz-name']//*[text()='1.']")).click();
		driver.findElement(By.xpath(".//*[@id='super-container']/div/div[2]/div[1]/div/div[4]/ul[2]/li[3]/div/div[1]/div[1]/div/div[2]/h3/span/a/span")).click();
	}
	
	
}