package MultiplewindowsorPopups;

import base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Rediffpopups extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("Chrome");
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.name("proceed")).click();
        //delay for alert to appear
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());

        //Alert mechanism
        Alert al=driver.switchTo().alert();
        al.accept();//ok
        //al.dismiss();//cancel
        driver.switchTo().defaultContent();

        Thread.sleep(2000);
        driver.quit();


    }
}
