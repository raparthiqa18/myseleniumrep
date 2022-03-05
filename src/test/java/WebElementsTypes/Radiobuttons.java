package WebElementsTypes;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.System.getProperty;

public class Radiobuttons extends TestBase {

    @BeforeTest
    public void beforetest(){
        launchBrowser("chrome");

    }


    @Test(priority = 0, enabled = false)
    public void radiobuttonTest1() throws InterruptedException {
        driver.get(System.getProperty("user.dir") + "\\src\\test\\resources\\Radiobuttons.html");
        //using the customized path: Radio buttons contain a unique attribute, i.e., value, so we use the value attribute to handle the radio button.
        driver.findElement(By.xpath("//input[@value='Banana']")).click(); //customized XPATH
//        driver.findElement(By.cssSelector("body > input[type=radio]:nth-child(5)")).click();
        //handling the radio buttons dynamically
        List<WebElement> rdbtns = driver.findElements(By.xpath("//input[@type='radio']"));
        rdbtns.get(2).click();
        Thread.sleep(3000);
    }

    @Test
    public void radiobuttonsTest2() throws InterruptedException {
        driver.get("https://www.chabadpotomac.com/templates/articlecco_cdo/aid/1094542/jewish/HS-Registration-Form-New-Student.htm");

        List<WebElement> rdbtns=driver.findElements(By.name("reading_proficiency"));
        System.out.println("No. of radio buttons: " + rdbtns.size());
        rdbtns.get(1).click();
        System.out.println(rdbtns.get(0).getAttribute("checked"));//Radio button checked: true; Unchecked: false
        System.out.println(rdbtns.get(1).getAttribute("checked"));//Radio button checked: true; Unchecked: false
        System.out.println(rdbtns.get(2).getAttribute("checked"));//Radio button checked: true; Unchecked: false
        System.out.println(rdbtns.get(2).getAttribute("value"));//Radio button name
        driver.findElement(By.xpath("//input[@value='well']")).click();
        Thread.sleep(3000);
        driver.quit();
    }

}
