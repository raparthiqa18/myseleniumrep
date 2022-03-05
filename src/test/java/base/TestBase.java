package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop = null;
    public static String url="";
    public static WebDriverWait wait=null;
    public static WebDriver launchBrowser(String browserName){
        if (browserName.equalsIgnoreCase("Chrome")){
//            System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Rakesh\\Professional\\Automation\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            options.addArguments("disable-infobars");
            options.addArguments("--disable-extensions");
            //options.addArguments("--headless");
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);//normal, eager, none
//            options.addArguments("user-data-dir=C:\\Users\\USER\\AppData\\Local\\Google\\Chrome\\User Data");
            WebDriverManager.chromedriver().setup();//selenium 4 feature
            driver=new ChromeDriver(options);
        }else if (browserName.equalsIgnoreCase("Firefox")){
            driver=new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("Edge")){
            driver=new EdgeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        try {
            wait=new WebDriverWait(driver, Duration.ofSeconds(20));
            prop = new Properties();
            FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Project.properties");
            prop.load(fis);
            url=prop.getProperty("url");
            //System.out.println(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return driver;
    }
    public static boolean isElementPresent(String elementXpath){
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            System.out.println("Pass");
            return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
