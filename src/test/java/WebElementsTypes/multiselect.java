package WebElementsTypes;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class multiselect extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        driver.navigate().to("http://demos.devexpress.com/aspxeditorsdemos/ListEditors/MultiSelect.aspx");
//        driver.findElement(By.id("ContentHolder_lbSelectionMode_I")).click();
//        driver.findElement(By.id("ContentHolder_lbSelectionMode_DDD_L_LBI1T0")).click();
        Thread.sleep(5000);

        // Perform Multiple Select
        Actions builder = new Actions(driver);
        WebElement select = driver.findElement(By.id("ContentHolder_lbFeatures_LBT"));
        List<WebElement> options = select.findElements(By.tagName("td"));
        options.get(1).click();
        options.get(3).click();
        options.get(4).click();

        Thread.sleep(5000);
        driver.quit();


    }
}
