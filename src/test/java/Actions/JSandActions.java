package Actions;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSandActions extends TestBase {
    public static void main(String[] args) {

        launchBrowser("chrome");
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        JavascriptExecutor js= (JavascriptExecutor) (driver);

        try {
            //1. To open a browser and url
            //js.executeScript("window.location='https://google.com'");
/*
            //2. To get the title of a webpage
            String script="return document.title;";
            String title= (String) js.executeScript(script, args);
            System.out.println(title);

            //3. Click a button
            driver.switchTo().frame("iframeResult");
            js.executeScript("myFunction()");
            Thread.sleep(2000);
            driver.switchTo().alert().accept();

            //4. Highlight the button
            WebElement btn=driver.findElement(By.xpath("/html/body/button"));
            js.executeScript("arguments[0].style.border='5px solid red'", btn);
            Thread.sleep(2000);

            //5. Scroll down the page
            driver.navigate().to("https://www.w3schools.com/");
            WebElement certbt=driver.findElement(By.xpath("//*[@id=\"getdiploma\"]/a"));
            js.executeScript("arguments[0].scrollIntoView(true);", certbt);
            js.executeScript("arguments[0].style.border='5px solid red'", certbt);
            Thread.sleep(2000); */

            //6. Click on a webelement
            driver.navigate().to("https://login.yahoo.com/");
            driver.findElement(By.id("login-username")).sendKeys("test@gmail.com");
            WebElement checkbox=driver.findElement(By.xpath("//*[@id=\"persistent\"]"));
            //checkbox.click();//does not work as Exception in thread "main" org.openqa.selenium.ElementNotInteractableException: element not interactable
            //driver.findElement(By.xpath("//*[@id=\"login-username-form\"]/div[3]/div[1]/span/label")).click();//this works
            //js.executeScript("document.getElementById('persistent').click()"); //Method 1
            //or
            js.executeScript("arguments[0].click()", checkbox);
            Thread.sleep(10000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            driver.quit();
        }

        //Accepting alerts



    }
}
