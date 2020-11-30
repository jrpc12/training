package app;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class GoogleTest{
	
	public GoogleTest(){}
	
	@Test
	public void search(){
		
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
        WebElement searchtxt = driver.findElement(By.className("gLFyf"));
        searchtxt.sendKeys("demo");
        searchtxt.sendKeys(Keys.ESCAPE);
		driver.findElement(By.className("gNO89b")).click();
		
		Assert.assertEquals(driver.findElement(By.id("result-stats")).getText().contains("resultados"),true);
		
		
	}
	
}