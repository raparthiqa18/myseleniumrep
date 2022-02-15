package Actions;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Rightclickusingactions extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        driver.get("https://docs.github.com/en/pages");
        Actions act=new Actions(driver);
        try{
            WebElement obj=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/div[3]/p/a"));

            act.contextClick(obj).perform();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Thread.sleep(3000);
            driver.quit();
        }


    }
}
