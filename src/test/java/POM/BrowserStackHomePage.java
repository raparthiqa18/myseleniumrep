package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class BrowserStackHomePage {
    WebDriver driver;

//    By Header = By.cssSelector("#post-26 > div:nth-child(1) > div > div > div > article.hero-unit.hero-unit--v2 > div > div > div > div.text-section.text-center.no-pad > h1");
//    By getStarted = By.cssSelector("#signupModalButton");

    @FindBy(css = "#post-26 > div:nth-child(1) > div > div > div > article.hero-unit.hero-unit--v2 > div > div > div > div.text-section.text-center.no-pad > h1")
    WebElement Header;

    @FindBy(css = "#signupModalButton")
    WebElement getStarted;


    public BrowserStackHomePage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        PageFactory.initElements(factory, this);
    }

    public void verifyHeader(){
//        String getHeadertext = driver.findElement(Header).getText();
           String getHeadertext = Header.getText();
           Assert.assertEquals(getHeadertext, "App & Browser Testing Made Easy");

    }

    public void clickongetStarted(){
//        driver.findElement(getStarted).click();
          getStarted.click();
    }

}
