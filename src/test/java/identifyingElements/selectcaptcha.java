package identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class selectcaptcha extends TestBase {
    public static void main(String[] args) {

        try{
            launchBrowser("Chrome");
            driver.get("https://rsps100.com/vote/760");

        new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

            new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-checkmark"))).click();
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
    }
}
