package selenium4features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class WindowandTabmanagement {
    WebDriver driver;

    @BeforeMethod
    public void setuUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://flipkart.com");
    }

    @Test
    public void testNewWindow(){
        WebDriver newWindow=driver.switchTo().newWindow(WindowType.WINDOW);
        newWindow.get("https://google.com");
        System.out.println("Title: " + driver.getTitle());
    }

    @Test
    public void testNewTab(){
        WebDriver newtab=driver.switchTo().newWindow(WindowType.TAB);
        newtab.get("https://linkedin.com");
        System.out.println("Title: " + driver.getTitle());
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
