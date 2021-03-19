package app.common;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Automation {

    private static String driverLocation = "drivers/chromedriver/";
    public Automation(){}

    public static synchronized  WebDriver getDriver(String browserName) throws Exception{

        WebDriver driver = null;
        switch(browserName){

            case "chrome":
                System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
            case "edge":
            case "internetexplorer":
            case "safari":
                throw new Exception("Not Implemented");
            default:
                System.setProperty("webdriver.chrome.driver", driverLocation + "chromedriver.exe");
                driver = new ChromeDriver();

        }

        //maximize window
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        //global timeout to find an element
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);        

        return driver;

    }

    public void init(){ }

    public static synchronized void closeDriver(WebDriver driver){
        driver.close();
        driver.quit();

    }

}