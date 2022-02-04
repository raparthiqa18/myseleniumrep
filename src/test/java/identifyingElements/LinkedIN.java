package identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LinkedIN extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        driver=launchBrowser("Chrome");
        driver.get("https://www.linkedin.com/login?fromSignIn=true&trk=guest_homepage-basic_nav-header-signin");

        //XPATH
//        Thread.sleep(30000);
//        WebElement userName=driver.findElement(By.id("session_key"));
//        userName.sendKeys("rakesh18raparthi@gmail.com");
//        System.out.println(userName.getAttribute("value"));
//        System.out.println(userName.getLocation().x);
//        System.out.println(userName.getLocation().y);
//        driver.findElement(By.name("session_password")).sendKeys("test");
//        driver.findElement(By.className("sign-in-form__submit-button")).click();
//        WebElement userName=driver.findElement(By.xpath("//*[@id=\"username\"]"));
//        userName.sendKeys("test");

        //   CSS
        WebElement userName=driver.findElement(By.cssSelector("#username"));
        userName.sendKeys("TestCSS");


    }

}
