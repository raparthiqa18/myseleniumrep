package Explicitwait;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class exercise extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        driver.get("https://www.awwwards.com/sites/khoa-le");

        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div[2]/div[2]/strong/a")).click();
//        Thread.sleep(4000);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"tab-login-form\"]/div/div[1]/form/div/ul/li[1]/div/div/label/input")));

        if(isElementPresent("//*[@id=\"tab-login-form\"]/div/div[1]/form/div/ul/li[1]/div/div/label/input")){
            driver.findElement(By.xpath("//*[@id=\"tab-login-form\"]/div/div[1]/form/div/ul/li[1]/div/div/label/input")).sendKeys("test");
        }
    }

    public static boolean isElementPresent(String elementXpath){
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(elementXpath)));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
            System.out.println("Pass"
            );return true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
