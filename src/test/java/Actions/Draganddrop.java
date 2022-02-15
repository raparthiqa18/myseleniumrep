package Actions;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Draganddrop extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        driver.get("https://jqueryui.com/droppable/");
        Actions act=new Actions(driver);
        /*https://dhtmlx.com/docs/products/dhtm...
        https://jqueryui.com/draggable/
        https://www.selenium.dev/selenium/doc...
        https://www.youtube.com/playlist?list...
        */

        try{
            driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));
            WebElement drag=driver.findElement(By.xpath("//*[@id=\"draggable\"]"));
            WebElement drop=driver.findElement(By.xpath("//*[@id=\"droppable\"]"));
            act.dragAndDrop(drag, drop).perform();
            driver.navigate().to("https://dhtmlx.com/docs/products/dhtmlxTree/");


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Thread.sleep(3000);
            driver.quit();
        }

    }
}
