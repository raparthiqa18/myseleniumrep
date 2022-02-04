package identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class dropdown extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        try{
            launchBrowser("Chrome");
            driver.get("https://www.qtpselenium.com/contact-us");
            WebElement droplist=driver.findElement(By.cssSelector("#userCountry"));
            Select s=new Select(droplist);

            s.selectByIndex(3);
            Thread.sleep(2000);
            s.selectByValue("4");
            Thread.sleep(2000);
            s.selectByVisibleText("Denmark");
            System.out.println(s.getFirstSelectedOption().getText());

            Thread.sleep(2000);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }



    }
}
