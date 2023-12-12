package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseTest;

public class ValidateFiltersPage extends BaseTest {
	
	@Test
	public static void Validate() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(loc.getProperty("searchInputBox"))).sendKeys("phone");
		
        driver.findElement(By.xpath(loc.getProperty("searchButton"))).click();
        
       
        WebElement selectedFilter = driver.findElement(By.xpath(loc.getProperty("selectFilter")));
        JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("arguments[0].click();", selectedFilter);
	    String s = driver.findElement(By.xpath(loc.getProperty("selected"))).getText();
	  
        List<WebElement> filteredProducts = driver.findElements(By.xpath("filteredResult"));

        boolean areProductsFiltered = true;
        
        for (WebElement product : filteredProducts) {
            if (!product.getText().toLowerCase().contains(s.toLowerCase())) {
                areProductsFiltered = false;
                break;
            }
        }
        
        if (areProductsFiltered) {
            System.out.println("Filtered products contain '" + s + "'. Filter is successful.");
        } else {
            System.out.println("Filtered products do not contain '" + s + "'. Filter failed.");
        }


		
	}

}
