package Advanced;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class spicejet extends TestBase {

    @BeforeTest
    public void testsetup(){
        launchBrowser("chrome");
    }

    @Test
    public void searchflights(){
        try{
            driver.get("https://www.spicejet.com/");
//            driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[1]/div[2]/div[2]")).click();
//            driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div[1]")).click();
//            Thread.sleep(1000);
//            driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[1]/div[1]/div[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div")).click();
//            driver.findElement(By.xpath("//div[text()='International']")).click();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            WebElement fromitem=driver.findElement(By.xpath("//div[text()='Vidyanagar Airport']"));
            WebElement divWithScrollbarElement=driver.findElement(By.xpath("//*[@id=\"main-container\"]/div/div[1]/div[3]/div[2]/div[3]/div/div[1]/div[2]/div[2]/div[2]/div[2]"));
//            fromitem.click();
            js.executeScript(
                    "arguments[0].scrollTop=arguments[1].offsetTop",
                    divWithScrollbarElement,
                    fromitem);
            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }finally {

            driver.quit();
        }
    }


}
