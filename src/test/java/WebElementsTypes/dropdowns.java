package WebElementsTypes;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class dropdowns extends TestBase {

    @BeforeTest
    public void testsetup(){
        launchBrowser("chrome");

    }

    @Test(enabled=true, priority = 0)
    public void dropdownTest1(){
       try{
           driver.get("https://www.qtpselenium.com/contact-us");
           WebElement wedropdown=driver.findElement(By.name("country_id"));
           //To scroll
           JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", wedropdown);
            //To select an option from dropdown
           Select dropdown = new Select(wedropdown);
           dropdown.selectByVisibleText("India");
           Thread.sleep(1000);
           dropdown.selectByValue("12");
           Thread.sleep(1000);
           dropdown.selectByIndex(14);
           Thread.sleep(1000);

       }catch(Exception e){
           e.printStackTrace();
       }finally {
           driver.quit();
       }
    }
}
