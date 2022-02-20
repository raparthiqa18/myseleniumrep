package testNG;

import base.TestBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTitle extends TestBase {


    @Test
    public void titleTest(){
        launchBrowser("chrome");
        driver.get("https://ebay.com");
        String expectedTitle="Electronics , Cars, Fashion, Collectibles & More | eBay";
        String expectedText="Search";
        String actualTest=driver.findElement(By.xpath("//*[@id=\"gh-btn\"]")).getAttribute("value");
        Assert.assertEquals(driver.getTitle(), expectedTitle, "Title verification failed");
        Assert.assertEquals(actualTest, expectedText, "Text verification failed");


        driver.quit();
    }

}
