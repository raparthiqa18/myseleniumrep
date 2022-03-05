package selenium4features;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class relativelocators {
    WebDriver driver;

    @BeforeMethod
    public void setuUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com");
    }

    @Test
    public void locatorsTest(){
        WebElement loginPanel = driver.findElement((By.id("logInPanelHeading")));
        WebElement credentials = driver.findElement(RelativeLocator.with(
                By.tagName("span")).above(loginPanel));
        System.out.println(credentials.getText());
    }

    @Test
    public void testListofElements(){
        System.out.println(driver.getTitle());
        List<WebElement> allsocialMedia=driver.findElements(with(By.tagName("img)")).near(By.id("footer")));

        for(WebElement s:allsocialMedia){
            System.out.println(s.getAttribute("alt"));
        }
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
