package Test.identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;

public class cnnwebelements extends TestBase {
    public static void main(String[] args) {
        launchBrowser("Chrome");
        driver.get("https://cnn.com");
        driver.getTitle();
        //isdisplayed only checks the visibility of element and not the presence
        driver.findElement(By.cssSelector("#menuButton > svg > path:nth-child(3)")).click();//click menu bar
        System.out.println(driver.findElement(By.xpath("//*[@id=\"header-nav-container\"]/div/div[2]/div/div[3]/nav/ul/li[2]/ul/li[3]/a")).isDisplayed());//click US elections in trailer
        driver.findElement(By.xpath("//*[@id=\"header-nav-container\"]/div/div[2]/div/div[3]/nav/ul/li[2]/ul/li[3]/a")).click();

        //div[@id= 'footer-wrap']/footer/div[2]/div/div/nav/ul/li[2]/ul/li[3]/a


    }
}
