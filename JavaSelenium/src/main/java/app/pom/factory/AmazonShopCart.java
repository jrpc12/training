package app.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import app.common.*;

public class AmazonShopCart extends Automation {

    private WebDriver driver = null;
    private String domainUrl = "https://www.amazon.com.mx/gp/cart/view.html/ref=lh_cart"; 

    @FindBy(id = "nav-cart-count")
    WebElement shopcartCounter;

    public AmazonShopCart(WebDriver driver){
        super();
        this.driver = driver;
    }

    @Override
    public void init(){
        driver.get(domainUrl);
     }

    public int getTotatItemsInShopCart(){
        String txtTotal = shopcartCounter.getText();
        return Integer.parseInt(txtTotal);
    }


    
}
