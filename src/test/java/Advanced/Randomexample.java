package Advanced;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Randomexample extends TestBase {
    public static void main(String[] args) {
        try{
            launchBrowser("chrome");
            driver.get("https://google.com");

            //To simulate mouse hovering on golfclubs tab
            WebElement golfclubs= driver.findElement(By.xpath("//*[@id=\"header-navigation\"]/div[1]/ul/li[3]/a"));
            Actions act=new Actions(driver);
            act.moveToElement(golfclubs);//******* To mouse hover *******
            act.build().perform();

            //explicit wait
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CLUBS_1\"]/ul/li[3]/ul/li/a/span")));

            //To choose any random link under golfclubs tab
            Random r=new Random();
            List<WebElement> links=driver.findElements(By.xpath("//div[@id='CLUBS_1']/descendant::a"));
            int n=r.nextInt(links.size());//gives random number between 0 to links.size()
            links.get(n).click();//clicks on random link


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }


    }
}
