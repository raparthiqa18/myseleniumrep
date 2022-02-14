package Test;

import org.openqa.selenium.*;
import java.io.*;
import org.openqa.selenium.chrome.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PetWiki2 {
    public static String getLoadedData(WebDriver driver) {
        WebElement ldbtn=driver.findElement(By.id("load-button"));
        String retstr=null;
        try{
            ldbtn.click();

            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.elementToBeClickable(By.id("load-button")));

            if (ldbtn.isEnabled()){
                retstr= driver.findElement(By.id("content")).getText();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return retstr;
    }
}