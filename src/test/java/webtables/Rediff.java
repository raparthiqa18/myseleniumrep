package webtables;

import base.TestBase;
import org.apache.commons.io.input.WindowsLineEndingInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Rediff extends TestBase {
    public static void main(String[] args) {
        launchBrowser("chrome");
        driver.get("https://money.rediff.com/indices/nse/NIFTY-50?src=moneyhome_nseIndices");

        //table[@class='dataTable']   => table
        //table[@class='dataTable']/tbody/tr[3]  => 3rd row
        //table[@class='dataTable']/tbody/tr[3]/td[2]   => 3rd row 4th column cell
        //table[@class='dataTable']/tbody/tr/td[4] => entire 4th col

        //table.dataTable > tbody > tr:nth-child(2) > td:nth-child(4)   2nd row 4th column using CSS
        //table.dataTable > tbody > tr:nth-child(3)  => entire 3rd row
        //table.dataTable > tbody > tr:nth-child(3)  > td  => each cell in 3rd row

        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"queryTop\"]/div/div[3]/div/input")));

            System.out.println(driver.findElement(By.xpath("//table[@class='dataTable']")).isDisplayed());
            List<WebElement> companynames=driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
            for (int i=0; i<companynames.size(); i++){
                if (companynames.get(i).getText().trim().equals("Shree Cement")){
                    WebElement price=driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr["+ 40 +"]/td[3]"));
                    System.out.println(price.getText());
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            driver.quit();
        }

    }
}
