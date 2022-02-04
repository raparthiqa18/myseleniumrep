package Multipleobjects;

import base.TestBase;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;

public class cnnheaderslinktest2 extends TestBase {
    public static int resp_code=0;
    public static SoftAssert sa=new SoftAssert();
    public static void main(String[] args) {
        launchBrowser("chrome");
        driver.get("https://cnn.com");
        String xpath1="//*[@id=\"header-nav-container\"]/div/div[1]/div/div[2]/nav/ul/li[";
        String xpath2="]/a";


        try{
            int i=1;
            while(isElementPresent(xpath1 + i+ xpath2)){
                String txt=driver.findElement(By.xpath(xpath1 + i+ xpath2)).getText();
                String href=driver.findElement(By.xpath(xpath1 + i+ xpath2)).getAttribute("href");
                sa.assertTrue(validateResponsecode(href), "Invalid response code");
                driver.findElement(By.xpath(xpath1 + i+ xpath2)).click();
                System.out.println(driver.getTitle());
                driver.navigate().back();
                i++;
            }

//            for (int i=1; i<9; i++){
//                String txt=driver.findElement(By.xpath(xpath1 + i+ xpath2)).getText();
//                String href=driver.findElement(By.xpath(xpath1 + i+ xpath2)).getAttribute("href");
//                sa.assertTrue(validateResponsecode(href), "Invalid response code");
//                driver.findElement(By.xpath(xpath1 + i+ xpath2)).click();
//                System.out.println(driver.getTitle());
//                driver.navigate().back();
//            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
            sa.assertAll();
        }


    }
    public static boolean validateResponsecode(String url) throws IOException {
        resp_code= Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
        try{
            if (resp_code==200){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isElementPresent(String elementXpath){
        try{
            if (driver.findElement(By.xpath(elementXpath)).isEnabled()){
                return true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return false;

    }
}
