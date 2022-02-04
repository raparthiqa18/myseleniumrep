package Multipleobjects;

import base.TestBase;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class Validatemultiplelinks extends TestBase {
    public static void main(String[] args) {
        launchBrowser("Chrome");
        String url="https://www.cnn.com";
        driver.get(url);
        int resp_code=0;
        List<WebElement> links=driver.findElements(By.tagName("a"));
        try {
            for (WebElement l: links ) {
                System.out.println(l.isDisplayed() + "   " + l.isEnabled());
                url=l.getAttribute("href");
                resp_code= Request.Get(url).execute().returnResponse().getStatusLine().getStatusCode();
                System.out.println("Response code of url: " + url +" is : " + resp_code);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }


    }
}
