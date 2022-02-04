package identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;

public class magicbricks extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        try{
            launchBrowser("Chrome");
            driver.get("https://www.magicbricks.com/");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//*[@id=\"commercialIndex\"]/header/section[2]/div/ul/li[2]")).click();
            driver.findElement(By.xpath("//*[@id=\"staticSwiperSliderRent\"]/div[1]/ul/li[1]/a")).click();
        }catch(Exception e){
            e.printStackTrace();

        } finally {
//            driver.quit();
        }

    }
}
