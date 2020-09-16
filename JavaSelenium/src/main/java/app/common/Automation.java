package app.common;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class Automation {

    private static String driverLocation = "browserDrivers/";
    public Automation(){}

    public static WebDriver getDriver(String browserName) throws Exception{

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
        //global timeou to find element
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);        

        return driver;

    }

    public void init(){ }

    public static void closeDriver(WebDriver driver){
        driver.close();

    }

}