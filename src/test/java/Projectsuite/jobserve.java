package Projectsuite;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.SQLOutput;
import java.util.List;

public class jobserve extends TestBase {
    public static void main(String[] args) throws Exception {
        launchBrowser("chrome");
        driver.get("https://www.jobserve.com/hk/en/Job-Search/");
        try {
            Thread.sleep(2000);
            if (isElementPresent("industrieslist_xpath")){
                driver.findElement(getObjectlocator("industrieslist_xpath")).click();
            }
            if (isElementPresent("indselectall_xpath")){
                driver.findElement(getObjectlocator("indselectall_xpath")).click();
            }

            selectcheckboxes("Education,Engineering", "indEng_class");
//            if (isElementPresent("industrieslist_xpath")){
//                driver.findElement(getObjectlocator("industrieslist_xpath")).click();
//            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }

    }

    public static void selectcheckboxes(String chekboxlist, String locatorkey){
        String cblist[]=chekboxlist.split(",");
        List<WebElement> checkblist=driver.findElements(getObjectlocator(locatorkey));
        for (int i=0; i<cblist.length; i++){
            for (WebElement cb:checkblist ) {
                if(cb.getText().equals(cblist[i])){
                    cb.click();
                }
            }
        }
    }

    public static By getObjectlocator(String locatorkey){
        if(locatorkey.endsWith("_id")){
            return By.id(prop.getProperty(locatorkey));
        }else if(locatorkey.endsWith("_cssSelector")){
            return By.cssSelector(prop.getProperty(locatorkey));
        }else if(locatorkey.endsWith("_xpath")){
            return By.xpath(prop.getProperty(locatorkey));
        }else if(locatorkey.endsWith("_linkText")){
            return By.linkText(prop.getProperty(locatorkey));
        }else{
            return By.className(prop.getProperty(locatorkey));
        }
    }

    public static boolean isElementPresent(String locatorkey){

        By locator=getObjectlocator(locatorkey);

        // Clickable, Visible, Presence
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        }catch(Exception e){
            e.printStackTrace();

        }
        return false;
    }
}
