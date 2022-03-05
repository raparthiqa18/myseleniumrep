package selenium4features;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utils.utils;

import java.io.File;
import java.io.IOException;

public class CaptureScreenshot extends TestBase {
    public static File screenshot;
    static utils utils;
    public static void main(String[] args) throws IOException {
    launchBrowser("chrome");

    driver.get("https://www.facebook.com/");
        //Take the screenshot
        screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + File.separator + "Screenshots"+ File.separator + "Screenshot.PNG"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Selenium 4 -> capture screenshot of a specific WebElement
        WebElement emailId=driver.findElement(By.name("email"));

        FileUtils.copyFile(emailId.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir") + File.separator + "Screenshots"+ File.separator + "Screenshot" + utils.getTimestamp() + ".PNG"));


        driver.quit();



    }
}
