package Advanced;

import base.TestBase;
import org.openqa.selenium.Cookie;

import java.util.Iterator;
import java.util.Set;

public class Cookiesexercise extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        driver.get("https://google.com");
        try{
            Set<Cookie> cookies=driver.manage().getCookies();
            System.out.println(cookies.size());
            Iterator<Cookie> it=cookies.iterator();
            while(it.hasNext()){
                System.out.println(it.next());
                System.out.println("*********************");
            }
            Cookie mycookie=new Cookie("Countrycode", "HK");
            driver.manage().addCookie(mycookie);
            driver.manage().getCookies().size();

        }catch(Exception e){

        }finally {
            Thread.sleep(2000);
            driver.quit();
        }


    }
}
