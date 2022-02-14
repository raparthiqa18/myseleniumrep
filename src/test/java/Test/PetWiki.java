package Test;

import base.TestBase;
import org.openqa.selenium.*;
import java.io.*;
import java.time.Duration;

import org.openqa.selenium.chrome.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PetWiki extends TestBase {
    public static void main(String[] args) {
        launchBrowser("chrome");
        driver.get("file:///C:/Users/USER/Desktop/test.html");
        System.out.println(getlink(driver));
    }

    public static String getlink(WebDriver driver) {
        String retstr = null;
        try {
            WebElement ldbtn = driver.findElement(By.id("load-button"));
            ldbtn.click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

            wait.until(ExpectedConditions.elementToBeClickable(By.id("load-button")));
            if (ldbtn.isEnabled()) {
                WebElement content = driver.findElement(By.id("content"));
                retstr = content.getText();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retstr;
    }

    public static String getLoadedData(WebDriver driver) {
        String retstr = null;
        try{
            WebElement ldbtn = driver.findElement(By.id("load-button"));
            ldbtn.click();
            WebDriverWait wait = new WebDriverWait(driver, 1);

            wait.until(ExpectedConditions.elementToBeClickable(By.id("load-button")));
            if (ldbtn.isEnabled()) {
                WebElement content = driver.findElement(By.id("content"));
                retstr = "\"" + content.getText().substring(0, 12) + "is a breed of dog in the toy group.";
            }
        }catch(Exception e){
            e.printStackTrace();
        }
            return retstr;


    }
}
