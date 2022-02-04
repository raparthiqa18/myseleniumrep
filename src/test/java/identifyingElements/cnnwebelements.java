package identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;

public class cnnwebelements extends TestBase {
    public static void main(String[] args) {
        launchBrowser("Chrome");
        driver.get("https://cnn.com");
        //isdisplayed only checks the visibility of element and not the presence
        driver.findElement(By.cssSelector("#menuButton > svg > path:nth-child(3)")).click();
        System.out.println(driver.findElement(By.xpath("//*[@id=\"header-nav-container\"]/div/div[2]/div/div[3]/nav/ul/li[2]/ul/li[3]/a")).isDisplayed());
        driver.findElement(By.xpath("//*[@id=\"header-nav-container\"]/div/div[2]/div/div[3]/nav/ul/li[2]/ul/li[3]/a")).click();


    }
}
