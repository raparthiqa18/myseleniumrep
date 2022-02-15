package Actions;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;



public class DoubleclickActions extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        driver.get("https://api.jquery.com/dblclick/");
        Actions act=new Actions(driver);
        try{
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
            WebElement obj=driver.findElement(By.xpath("//span[text()= 'Double click the block']/parent::body/div"));
            act.doubleClick(obj).perform();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Thread.sleep(3000);
            driver.quit();
        }


    }
}
