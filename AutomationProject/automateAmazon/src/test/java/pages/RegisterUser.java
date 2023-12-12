package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;

public class RegisterUser extends BaseTest {

	@Test
	public static void register() {
		
		driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"createAccountSubmit\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"ap_customer_name\"]")).sendKeys("Nisha Pawar");
		driver.findElement(By.xpath("//*[@id=\"ap_phone_number\"]")).sendKeys("12345789");
		
		driver.findElement(By.xpath("//*[@id=\"ap_password\"]")).sendKeys("abc@123");
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
	}
}
