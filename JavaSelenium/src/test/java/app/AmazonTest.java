package app;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import app.pom.*;
import app.common.*;

public class AmazonTest {

    AmazonTest(){}

    @Test
    public void searchProduct(){

        WebDriver driver = null;
        try{
            driver = Automation.getDriver("chrome");
            String productName = "piano";
            AmazonHome amazonHome = new AmazonHome(driver);
            amazonHome.init();
            String searchResult = amazonHome.searchProducExplicitWait(productName);

            Assert.assertEquals(searchResult.indexOf("resultados para \"" + productName + "\"") > -1, true);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }finally{
            Automation.closeDriver(driver);
        }
    }

    @Test
    public void addProductToShopCart() throws Exception{
        
        WebDriver driver = null;
        
        try{
            driver = Automation.getDriver("chrome");
            int productQty = 1;
            String productName = "piano";
            AmazonHome amazonHome = new AmazonHome(driver);
            amazonHome.init();
            amazonHome.searchProduct(productName);
            String cartMessage = amazonHome.addFirstProductToShopcart(productQty);

            Assert.assertEquals(cartMessage,"Agregado al carrito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }finally{
            Automation.closeDriver(driver);
        }
                
    }
    
    @Test
    public void validateCorrectToShopCartQuantity() throws Exception{
        
        WebDriver driver = null;
        
        try{
            driver = Automation.getDriver("chrome");

            int productQty = 2;
            String productName = "piano";
            AmazonHome amazonHome = new AmazonHome(driver);
            amazonHome.init();
            amazonHome.searchProduct(productName);
            amazonHome.addFirstProductToShopcart(productQty);
            AmazonShopCart shopcart = new AmazonShopCart(driver);
            shopcart.init();
            Assert.assertEquals(productQty, shopcart.getTotatItemsInShopCart()); 
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
            Assert.assertTrue(false);
        }finally{
            Automation.closeDriver(driver);
        }

    }

    
}