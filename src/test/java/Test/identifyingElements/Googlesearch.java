package Test.identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;

public class Googlesearch extends TestBase {
    public static void main(String[] args) {
        driver=launchBrowser("chrome");
        driver.get("https://google.com");
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Rakesh Raparthi ");
        driver.findElement(By.xpath("//div[@class='UUbT9']/div[2]/div[5]/center/input[1]")).click();


    }
}
