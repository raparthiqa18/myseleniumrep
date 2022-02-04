package utils;

import base.TestBase;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static base.TestBase.driver;

public class Screenshots extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");

        driver.get("https://google.com");
        Thread.sleep(2000);
        takescreenshot("C:\\Users\\USER\\Desktop\\Rakesh\\Professional\\Automation\\Selenium_Screenshots\\sample.jpeg");
        driver.quit();
    }


    public static void takescreenshot(String filepath){
        //take screenshot
        //save screrenshot
        //add screenshot to reports
        try{
            File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcfile, new File(filepath));
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
