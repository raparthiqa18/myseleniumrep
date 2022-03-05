package Test.identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;

public class zoho extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser(("chrome"));
        driver.get("https://www.zoho.com/signup.html?all_prod_page=true&ireft=ohome&src=home-header");
        boolean b=driver.findElement(By.xpath("//span[@id='signup-termservice']")).isEnabled();
        System.out.println(b);
//        Thread.sleep(2000);
//            driver.findElement(By.xpath("//span[@id='signup-termservice']")).click();

        int i=0;
        while(!driver.findElement(By.xpath("//*[@id=\"tos\"]")).isEnabled()){
            i++;
        }
        System.out.println(i);
        driver.findElement(By.xpath("//*[@id=\"tos\"]")).click();

        driver.findElement(By.cssSelector("#emailfield")).sendKeys("Test");
        System.out.println(driver.findElement(By.cssSelector("#emailfield")).getText());
        System.out.println(driver.findElement(By.cssSelector("#emailfield")).getAttribute("value"));
        System.out.println(driver.findElement(By.cssSelector(".signupbtn")).getAttribute("value"));
        Thread.sleep(3000);
        driver.quit();

    }
}
