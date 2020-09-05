package app.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app.common.*;

public class AmazonShopCart extends Automation {

    private WebDriver driver = null;
    private String domainUrl = "https://www.amazon.com.mx/gp/cart/view.html/ref=lh_cart"; 

    public AmazonShopCart(WebDriver driver){
        super();
        this.driver = driver;
    }

    @Override
    public void init(){
        driver.get(domainUrl);
     }

    public int getTotatItemsInShopCart(){
        String txtTotal = driver.findElement(By.id("nav-cart-count")).getText();
        return Integer.parseInt(txtTotal);
    }


    
}
