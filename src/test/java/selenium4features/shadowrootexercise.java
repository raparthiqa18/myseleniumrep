package selenium4features;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class shadowrootexercise extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        try{
            driver.get("https://developer.salesforce.com/signup");
            driver.findElement(By.id("onetrust-accept-btn-handler")).click();
            WebElement firstName=driver.findElement(By.tagName("sections-de-signup-form"));
//            firstName.sendKeys("Test");//does not work as it is a shadow element
            //Using Javascript executor

            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0,0)");//tO SCROLL THE WINDOW TO TOP
            js.executeScript("document.querySelector(\"sections-de-signup-form\").shadowRoot.querySelector('dx-input').shadowRoot.querySelector('input').value=\"test\"");


            //Selenium 4 feature
            firstName.getShadowRoot().findElement(By.cssSelector("dx-input")).getShadowRoot().findElement(By.cssSelector("input")).sendKeys("Test1234");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Thread.sleep(5000);
            driver.quit();
        }


    }

    //To return the Shadow root element
    public static WebElement getShadowRootElement(WebElement element) {
        WebElement ele = (WebElement) ((JavascriptExecutor)driver)
                .executeScript("return arguments[0].shadowRoot", element);
        return ele;
    }
}
