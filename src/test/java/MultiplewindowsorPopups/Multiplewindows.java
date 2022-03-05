package MultiplewindowsorPopups;

import base.TestBase;
import org.openqa.selenium.WindowType;

import java.util.Iterator;
import java.util.Set;

public class Multiplewindows extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        //selenium 4 feature
        launchBrowser("Chrome");
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.naukri.com");
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.naukri.com");

        //Window handles
        Set<String> s=driver.getWindowHandles();//ordered set
        System.out.println(s.size());
        Iterator<String> it=s.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        String firstwindow= it.next();
        driver.switchTo().window(firstwindow);
        Thread.sleep(2000);
        driver.quit();
    }
}
