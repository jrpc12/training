package app.factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;


import app.common.*;

public class AmazonHome extends Automation {

    private WebDriver driver = null;
    private String domainUrl = "https://www.amazon.com.mx"; 

    public AmazonHome(){
        super();
        try{
            driver = getDriver("chrome");
            driver.get(domainUrl);
        }catch(Exception ex){
            System.exit(0);
        }
    }

    public void searchProduct() throws InterruptedException {

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("piano");
        driver.findElement(By.className("nav-input")).click();

        Thread.sleep(2000);

        //waitForLoad(driver);

    }

    public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }
}
