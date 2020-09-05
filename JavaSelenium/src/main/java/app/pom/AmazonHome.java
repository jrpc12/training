package app.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import app.common.*;

public class AmazonHome extends Automation {

    private WebDriver driver = null;
    private static String domainUrl = "https://www.amazon.com.mx"; 

    public AmazonHome(WebDriver driver){
        super();
        this.driver = driver;
    }

    @Override
    public void init(){
        driver.get(domainUrl);
     }

    public String searchProduct(String product){

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(product);
        driver.findElement(By.className("nav-search-submit")).click();
        String searchTxt = driver.findElement(By.xpath("//span [@data-component-type='s-result-info-bar']")).getText();
        System.out.println(searchTxt);
        return searchTxt;

    }

    public String addFirstProductToShopcart(){

        driver.findElement(By.className("s-image")).click();
        Select quantitySelector = new Select(driver.findElement(By.id("quantity")));
        quantitySelector.selectByVisibleText("1");
        driver.findElement(By.id("add-to-cart-button")).click();
        String cartMessage = driver.findElement(By.id("huc-v2-order-row-messages")).getText();
        System.out.println(cartMessage);
        return cartMessage;
    }

    public String addFirstProductToShopcart(int quantity){

        driver.findElement(By.className("s-image")).click();
        Select quantitySelector = new Select(driver.findElement(By.id("quantity")));
        quantitySelector.selectByVisibleText(Integer.toString(quantity));
        driver.findElement(By.id("add-to-cart-button")).click();
        String cartMessage = driver.findElement(By.id("huc-v2-order-row-messages")).getText();
        System.out.println(cartMessage);
        return cartMessage;
    }

    
}
