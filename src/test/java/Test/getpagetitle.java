package Test;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class getpagetitle extends TestBase {
    public static void main(String[] args) {
        launchBrowser("chrome");
        driver.get("https://google.com");
        System.out.println(driver.getTitle());

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        wait.until(ExpectedConditions.elementToBeClickable(By.id("load-button")));
        try{

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
