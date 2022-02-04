package Advanced;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Action_Americangolf extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        driver.get("https://www.americangolf.co.uk/");

        //To simulate mouse hovering on golfclubs tab
        WebElement golfclubs= driver.findElement(By.xpath("//*[@id=\"header-navigation\"]/div[1]/ul/li[3]/a"));
        Actions act=new Actions(driver);
        act.moveToElement(golfclubs);//******* To mouse hover *******
        act.build().perform();

        //explicit wait
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"CLUBS_1\"]/ul/li[3]/ul/li/a/span")));

        driver.findElement(By.xpath("//*[@id=\"CLUBS_1\"]/ul/li[3]/ul/li/a/span")).click();
        //Thread.sleep(10000);
        waitForPageToLoad();
        //To scroll down
        WebElement slider=driver.findElements(By.xpath("//div[@class='noUi-handle noUi-handle-lower']")).get(1);
        int y=slider.getLocation().y-100;//y-100 so that page is scrolled and the slider is visible
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, "+y+")");//******* To scroll down the page  *******

        act.clickAndHold(slider).moveByOffset(100,0).release().build().perform(); //x=100, so that slider moves in x-axis *******

        Thread.sleep(2000);
        driver.quit();
    }

    public static void waitForPageToLoad() throws InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        int i=0;
        while(i!=10){
            String state=(String) js.executeScript("return document.readyState;");
            System.out.println(state);//complete, loading, interactive
            if(state.equals("complete")){
                break;
            }else{
                Thread.sleep(2000);
            }
            i++;
        }

        //Check for Jquery/Ajax
        i=0;
        while(i!=10){
            Long d=(Long)js.executeScript("return jQuery.active;");
            System.out.println(d);//0,1
            if(d.longValue() == 0){
                break;
            }else{
                Thread.sleep(2000);
            }
            i++;
        }

    }
}
