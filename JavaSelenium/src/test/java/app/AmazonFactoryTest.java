package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import app.pom.factory.*;
import app.common.*;

public class AmazonFactoryTest {

    WebDriver driver = null;
    AmazonHome amazonHome = null;

    AmazonFactoryTest(){
    }

    @Test
    public void searchProduct() throws Exception{

        driver = Automation.getDriver("chrome");
        String productName = "piano";
        amazonHome =  new AmazonHome(driver);
        PageFactory.initElements(driver, amazonHome);
        amazonHome.init();
        String searchResult = amazonHome.searchProduct(productName);
        Assert.assertEquals(searchResult.indexOf("resultados para \"" + productName + "\"") > -1, true);
        
        Automation.closeDriver(driver);
    }

    @Test
    public void addProductToShopCart() throws Exception{
        
        driver = Automation.getDriver("chrome");

        int productQty = 1;
        String productName = "piano";
        amazonHome = new AmazonHome(driver);
        PageFactory.initElements(driver, amazonHome);
        amazonHome.init();
        amazonHome.searchProduct(productName);
        String cartMessage = amazonHome.addFirstProductToShopcart(productQty);;
        Assert.assertEquals(cartMessage,"Agregado al carrito");
                
        Automation.closeDriver(driver);
    }

    

    @Test
    public void validateCorrectToShopCartQuantity() throws Exception{
        
        driver = Automation.getDriver("chrome");

        int productQty = 2;
        String productName = "piano";
        amazonHome = new AmazonHome(driver);
        PageFactory.initElements(driver, amazonHome);
        amazonHome.init();
        amazonHome.searchProduct(productName);
        amazonHome.addFirstProductToShopcart(productQty);
        AmazonShopCart shopcart = new AmazonShopCart(driver);
        shopcart.init();
        Assert.assertEquals(productQty, shopcart.getTotatItemsInShopCart());        

        Automation.closeDriver(driver);
    }

    public void dispose(){
        
    }
    
}