package Multipleobjects;

import base.TestBase;

import net.jodah.failsafe.internal.util.Assert;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class cnnheaders extends TestBase {
    public  static int resp_code=0;
    public static String url=null;
    public static SoftAssert softAssert=new SoftAssert();
    public static void main(String[] args) {
        launchBrowser("chrome");
        driver.get("https://cnn.com");

        try{
            List<WebElement> toplinks=driver.findElements(By.xpath("//*[@id=\"header-nav-container\"]/div/div[1]/div/div[2]/nav/ul/li/a"));
            System.out.println("Total links : " + toplinks.size());

            for (int i=0; i<toplinks.size(); i++){
                System.out.println(toplinks.get(i).getText());
                url=toplinks.get(i).getAttribute("href");
//                Assert.isTrue(validateResponsecode(url));
                softAssert.assertTrue(validateResponsecode(url));
                System.out.println(url + " " + resp_code);
                toplinks.get(i).click();
                System.out.println(driver.getTitle());
                driver.get("https://cnn.com");
                System.out.println("**************************");
                toplinks=driver.findElements(By.xpath("//*[@id=\"header-nav-container\"]/div/div[1]/div/div[2]/nav/ul/li/a"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
            softAssert.assertAll();
        }

    }

    public static boolean validateResponsecode(String url) throws IOException {
        resp_code=Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
       try{
           if (resp_code==200){
               return true;
           }
       }catch(Exception e){
           e.printStackTrace();
        }
        return false;
    }
}
