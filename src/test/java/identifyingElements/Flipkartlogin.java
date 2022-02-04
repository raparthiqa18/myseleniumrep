package identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;

public class Flipkartlogin extends TestBase{
    public static void main(String[] args) {
        driver=launchBrowser("Chrome");
        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//form[@autocomplete='on']/div[1]/input")).sendKeys("test");
    }
}
