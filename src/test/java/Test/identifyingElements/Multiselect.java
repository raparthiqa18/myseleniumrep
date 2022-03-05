package Test.identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.Iterator;
import java.util.List;

public class Multiselect extends TestBase {
    public static void main(String[] args) {
        try{launchBrowser("Chrome");
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
        Thread.sleep(3000);
        driver.switchTo().frame("iframeResult");
//        List<WebElement> lst=driver.findElements(By.xpath("//select[@name='cars']/option"));
//            wait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.name("cars"))));
        Select cars=new Select(driver.findElement(By.cssSelector("#cars")));
            cars.selectByVisibleText("Saab");
            cars.selectByVisibleText("Volvo");
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
