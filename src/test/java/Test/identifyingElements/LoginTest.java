package Test.identifyingElements;

import base.TestBase;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {


    public static void main(String[] args) {
        driver=launchBrowser("Chrome");
        driver.get("https://cnn.com");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }
}
