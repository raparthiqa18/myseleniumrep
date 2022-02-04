package Projectsuite;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Sakraworld extends TestBase {
    public static void main(String[] args) throws InterruptedException {
       //Doctor's appointment test

        try {
            launchBrowser("Chrome");
             driver.get(url);
//
//            wait.until(ExpectedConditions.elementToBeClickable(By.linkText(""))).click();
//            wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(""))).click();
            if (isElementPresent("doctorName_linkText")){
                driver.findElement(getObjectlocator("doctorName_linkText")).click();
            }
            if (isElementPresent("serviceName_cssSelector")){
                driver.findElement(getObjectlocator("serviceName_cssSelector")).click();
            }
            if (isElementPresent("name_id")){
                driver.findElement(getObjectlocator("name_id")).sendKeys(prop.getProperty("requestorName"));
            }
            if (isElementPresent("reqemail_cssSelector")){
                driver.findElement(getObjectlocator("reqemail_cssSelector")).sendKeys(prop.getProperty("requestorEmail"));
            }
            if (isElementPresent("reqmobile_xpath")){
                driver.findElement(getObjectlocator("reqmobile_xpath")).sendKeys(prop.getProperty("requestorMobile"));
            }


            WebElement genderlist=driver.findElement(By.id("req_gender"));
            Select s=new Select(genderlist);
            //System.out.println(s.getAllSelectedOptions().toString());
            s.selectByVisibleText("Male");
            List<WebElement> genders=s.getOptions();
            String expGenderlist[]= prop.getProperty("expectedgenderoptions").split(",");
            if (genders.size()==expGenderlist.length){
                for (int i=0; i<genders.size(); i++) {
                    System.out.println(genders.get(i).getText() +"  " + expGenderlist[i]);
                }
            }else{
                System.out.println("Gender list mismatch");
            }

            driver.findElement(By.id(prop.getProperty("DOB"))).click();
            // DOB
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate curdate=LocalDate.now();
            LocalDate localDate = LocalDate.parse(prop.getProperty("DOBvalue"), myFormatObj);
            System.out.println(localDate);
            String datetobeselected= localDate.format(myFormatObj.ofPattern("dd"));
            String month=localDate.format(myFormatObj.ofPattern("MMMM"));
            String year=localDate.format(myFormatObj.ofPattern("YYYY"));
            String monthYeartobeselected= month+ " " +year;
            System.out.println(monthYeartobeselected);
            String datedisplayed=driver.findElement(By.xpath(prop.getProperty("dateDisplayed"))).getText();
            System.out.println(datedisplayed);
            System.out.println(curdate);
            while(!monthYeartobeselected.equals(datedisplayed)){
//                if(localDate.compareTo(curdate)==1){
//                    //click forward icon
//                }else if(localDate.compareTo(curdate)== -1){
//                    //click backward icon
                    driver.findElement(By.cssSelector(prop.getProperty("calednarback"))).click();
//                }
                datedisplayed=driver.findElement(By.xpath(prop.getProperty("dateDisplayed"))).getText();
            }
            driver.findElement(By.xpath("//a[text()='"+ datetobeselected +"']")).click();
            System.out.println(datedisplayed);
             System.out.println(driver.findElement(By.xpath("//*[@id=\"radio2\"]")).isSelected());
            System.out.println(driver.findElement(By.xpath("//*[@id=\"radio1\"]")).isSelected());
            System.out.println(driver.findElement(By.xpath("//*[@id=\"radio2\"]")).getAttribute("value"));
            System.out.println(driver.findElement(By.xpath("//*[@id=\"radio1\"]")).getAttribute("value"));

            System.out.println(driver.findElement(By.xpath("//*[@id=\"radio1\"]")).isSelected());
             //after selecting DOB
            driver.findElement(By.xpath("//*[@id=\"radio1\"]")).click();
            System.out.println(driver.findElement(By.id("req_uhid")).getAttribute("value"));
            System.out.println(driver.findElement(By.id("req_uhid")).getText());
            driver.findElement(By.id("req_uhid")).sendKeys("34743874");

            System.out.println(driver.findElement(By.id("req_uhid")).getAttribute("value"));
            System.out.println(driver.findElement(By.id("req_uhid")).getText());
           // new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"recaptcha-anchor\"]"))).click();


            driver.findElement(By.id("req_submit")).click();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(3000);
            driver.quit();
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

    public static void formatDate(String DOBvalue){
        LocalDate localDate = LocalDate.parse(DOBvalue);
        System.out.println(localDate);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("dd")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMMM")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy")));
    }
}
