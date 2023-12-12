package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class AmazonHomePage extends BaseTest {

	@Test
	public static void homePage() throws InterruptedException {
		
		
		driver.findElement(By.xpath(loc.getProperty("searchInputBox"))).sendKeys("iphone");
		
        driver.findElement(By.xpath(loc.getProperty("searchButton"))).click();
        
  
        WebElement product = driver.findElement(By.xpath(loc.getProperty("selectProduct")));
        product.click();
        //JavascriptExecutor j = (JavascriptExecutor) driver;
	    //j.executeScript("arguments[0].click();", product);
        
        String productPrice = driver.findElement(By.xpath(loc.getProperty("price"))).getText();
        
        System.out.println("Product Price: " + productPrice);
        
        WebElement button = driver.findElement(By.xpath(loc.getProperty("addToCartButton")));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", button);
	      
	    
	}
}