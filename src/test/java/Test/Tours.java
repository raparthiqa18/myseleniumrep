package Test;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Tours extends TestBase {
    public static void main(String[] args) {
        launchBrowser("chrome");
        driver.get("file:///C:/Users/USER/Desktop/Delete/Test.html");
        //System.out.println(getLinkUrl(driver, "Wikimedia"));

        System.out.println(driver.findElements(By.xpath("//article")).size());
        System.out.println(driver.findElements(By.xpath("//article/p")).size());
        System.out.println(driver.findElements(By.xpath("//article/p[1]/img")).size());


//       try{
//           Thread.sleep(3000);
//           driver.findElement(By.linkText("TOUR")).click();
//           System.out.println("\"" + driver.findElement(By.xpath("//*[@id=\"rdNavBar\"]/div/div[2]/a[1]")).getText() + "\"");;
//       }catch(Exception e){
//           e.printStackTrace();
//       }



    }
    public static String getLinkUrl(WebDriver driver, String linkText) {
        String retstr=null;
        WebElement link=driver.findElement(By.xpath("//a[text()='"+linkText + "']"));

        try{
            if (link.isDisplayed()){
                retstr=link.getAttribute("href");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return retstr;
    }


}
