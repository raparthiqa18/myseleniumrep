package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BrowserStackSignUpPage {
    WebDriver driver;

//    By Header = By.xpath("//*[@id=\"signin_signup_form\"]/div[1]/div/div[1]/h1");
//    By userName = By.xpath("//*[@id=\"user_full_name\"]");
//    By businessEmail = By.xpath("//*[@id=\"user_email_login\"]");
//    By password = By.xpath("//*[@id=\"user_password\"]");

    @FindBy(xpath = "//*[@id=\"signin_signup_form\"]/div[1]/div/div[1]/h1")
    WebElement Header;
    @FindBy(xpath = "//*[@id=\"user_full_name\"]")
    WebElement userName;
    @FindBy(xpath = "//*[@id=\"user_email_login\"]")
    WebElement businessEmail;
    @FindBy(xpath = "//*[@id=\"user_password\"]")
    WebElement password;

    public BrowserStackSignUpPage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        PageFactory.initElements(factory, this);
    }

    public void verifyPageLoaded(WebDriverWait wait){
        wait.until(ExpectedConditions.elementToBeClickable(userName));
    }

    public void verifyHeader(){
        //String getHeadertext = driver.findElement(Header).getText();
        String getHeadertext = Header.getText();
        Assert.assertEquals(getHeadertext, "Create a FREE Account");
    }

    public void enterUserName(){
        //driver.findElement(userName).sendKeys("Testusername");
        userName.sendKeys("Testusername");
    }

    public void enterBusinessEmail(){
        //driver.findElement(businessEmail).sendKeys("testBusEmail@gmail.com");
        businessEmail.sendKeys("testBusEmail@gmail.com");
    }

    public void enterpassword(){
        //driver.findElement(password).sendKeys("testpassword");
        password.sendKeys("testpassword");
    }

}

