package Test.identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;

public class Nullskull extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        driver=launchBrowser("Chrome");
        driver.get("http://nullskull.com/articles/SumCaptchaTest.aspx");
        /*
        //*[@name="email"]
        //*[@id="email"]
        //input[@type='text']
        //*[contains(@id,"email")]
        //*[starts-with(@name, "email")] */
        driver.findElement(By.id("email")).sendKeys("Test id");
        Thread.sleep(3000);
//        driver.findElement(By.id("email")).clear();
//        driver.findElement(By.name("email")).sendKeys("Test name");
//        Thread.sleep(3000);
//        driver.findElement(By.id("email")).clear();
//        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("Test xpath");
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//*[@id='email']")).clear();
//        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Test xpath2");
//        Thread.sleep(3000);
//        driver.findElement(By.id("email")).clear();
//        driver.findElement(By.xpath("//*[contains(@id,\"email\")]")).sendKeys("Test xpath contains");
        int x=Integer.parseInt(driver.findElement(By.xpath("//div[@class=\"Yellowborder\"]/span[2]")).getText());
        int y=Integer.parseInt(driver.findElement(By.xpath("//div[@class=\"Yellowborder\"]/span[4]")).getText());
        String sum= String.valueOf(x+y);

        System.out.println("X: " + x + " Y: " + y + " = " + sum);
        driver.findElement(By.xpath("//*[contains(@name, \"Sum\")]")).sendKeys(sum);
        driver.findElement(By.name("Button1")).click();

        driver.quit();


    }

}
