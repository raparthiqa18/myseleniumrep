package identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Multiselect extends TestBase {
    public static void main(String[] args) {
        try{launchBrowser("Chrome");
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
        Thread.sleep(2000);
//        WebElement mutilist=driver.findElement(By.id("cars"));
//        Select s=new Select(mutilist);
//        s.selectByVisibleText("Saab");
//        s.selectByValue("opel");
        driver.findElement(By.xpath("//*[@id=\"runbtn\"]")).click();
        Thread.sleep(2000);

    }
        catch(Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }
        }
}
