package Test.identifyingElements;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Radiobuttons extends TestBase {
    public static void main(String[] args) {
        launchBrowser("Chrome");
        driver.get("https://www.chabadpotomac.com/templates/articlecco_cdo/aid/1094542/jewish/HS-Registration-Form-New-Student.htm");

        List<WebElement> rdbtns=driver.findElements(By.name("reading_proficiency"));
        System.out.println("No. of radio buttons: " + rdbtns.size());
        rdbtns.get(1).click();
        System.out.println(rdbtns.get(0).getAttribute("checked"));
        System.out.println(rdbtns.get(1).getAttribute("checked"));
        System.out.println(rdbtns.get(2).getAttribute("checked"));
        System.out.println(rdbtns.get(2).getAttribute("value"));
        driver.findElement(By.xpath("//input[text()='Well']")).click();



    }
}
