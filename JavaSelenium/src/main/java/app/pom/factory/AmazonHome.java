package app.pom.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import app.common.*;

public class AmazonHome extends Automation {

    private WebDriver driver = null;
    private static String domainUrl = "https://www.amazon.com.mx"; 
    
    @FindBy(id="twotabsearchtextbox")
    private WebElement tbSearch;
    @FindBy(css ="span[data-component-type='s-result-info-bar']")
    private WebElement resultBar;
    @FindBy(id="quantity")
    private WebElement selQuantity;
    @FindBy(id="add-to-cart-button")
    private WebElement addToCartButton;
    @FindBy(id="attachDisplayAddBaseAlert")
    private WebElement cartMessage;
    @FindBy(className = "s-image")
    private WebElement productImage;



    public AmazonHome(WebDriver driver){
        super();
        this.driver = driver;
    }

    @Override
    public void init(){
        driver.get(domainUrl);
     }

    public String searchProduct(String product){

        tbSearch.sendKeys(product);
        tbSearch.submit();
        String searchTxt = resultBar.getText();
        System.out.println(searchTxt);
        return searchTxt;
    }


    public String searchProductCSSSelector(String product){

        tbSearch.sendKeys(product);
        tbSearch.submit();
        String searchTxt = resultBar.getText();
        System.out.println(searchTxt);
        return searchTxt;
    }

    public String addFirstProductToShopcart(){

        productImage.click();
        Select quantitySelector = new Select(selQuantity);
        quantitySelector.selectByVisibleText("1");
        addToCartButton.click();
        String message = cartMessage.getText();
        System.out.println(message);
        return message;
    }

    public String addFirstProductToShopcart(int quantity) throws Exception {

        productImage.click();
        Select quantitySelector = new Select(selQuantity);
        quantitySelector.selectByVisibleText(Integer.toString(quantity));
        addToCartButton.click();
        Thread.sleep(5000);
        String message = cartMessage.getText();
        System.out.println(message);
        return message;
    }

    
}
