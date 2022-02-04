package Multipleobjects;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.List;

public class Multiplelinksextraction extends TestBase {
    public static void main(String[] args) {
        launchBrowser("Chrome");
        driver.get("https://www.flipkart.com/mens-tshirts/pr?sid=clo,ash,ank,edy&fm=neo%2Fmerchandising&iid=M_5171a8bb-d002-4c3a-81b2-fc9051da87ae_1_372UD5BXDFYS_MC.IF56C41VGEYS&otracker=hp_rich_navigation_2_1.navigationCard.RICH_NAVIGATION_Fashion~Men%2527s%2BTop%2BWear~Men%2527s%2BT-Shirts_IF56C41VGEYS&otracker1=hp_rich_navigation_PINNED_neo%2Fmerchandising_NA_NAV_EXPANDABLE_navigationCard_cc_2_L2_view-all&cid=IF56C41VGEYS");
        /*
        try {
            Thread.sleep(2000);
            List<WebElement> links=driver.findElements(By.tagName("a"));
            System.out.println(links.get(3).getText());
            System.out.println(links.size());
            for (WebElement l: links) {
                System.out.println(l.getText() + "     " + l.isDisplayed());
            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }*/
        //  Flipkart item name and price

        System.out.println(driver.findElements(By.xpath("//*[@class='IRpwTa']")).size());
        System.out.println(driver.findElements(By.cssSelector(".IRpwTa")).size());
        System.out.println(driver.findElements(By.xpath("//div[@class='_30jeq3']")).size());
        List<WebElement> tshirts=driver.findElements(By.cssSelector(".IRpwTa"));

//        for (WebElement s:tshirts) {
//            System.out.println(s.getText());
//        }
        System.out.println("*********************************");
        List<WebElement> tshirtsprices=driver.findElements(By.xpath("//div[@class='_30jeq3']"));
//        for (WebElement sp:tshirtsprices){
//            System.out.println(sp.getText());
//        }
        for (int i=0; i<tshirts.size(); i++){

                System.out.println("T-Shirt name: " +tshirts.get(i).getText()+ "T-Shirt price: " + tshirtsprices.get(i).getText());

        }


    }

}
