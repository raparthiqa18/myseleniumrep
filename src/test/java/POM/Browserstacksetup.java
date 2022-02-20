package POM;

import base.TestBase;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Browserstacksetup extends TestBase {
    BrowserStackSignUpPage objbrowserstacksignuppage;
    BrowserStackHomePage objbrowserstackhomepage;

    @BeforeTest
    public void setup(){
        launchBrowser("chrome");
        driver.get("https://www.browserstack.com/");
    }

    @Test (priority = 1)
    public void navigatetogetstartedpage(){
        objbrowserstackhomepage = new BrowserStackHomePage(driver);
        objbrowserstackhomepage.verifyHeader();
        objbrowserstackhomepage.clickongetStarted();
    }

    @Test(priority = 2)
    public void entersignupdetails(){

        objbrowserstacksignuppage = new BrowserStackSignUpPage(driver);
        objbrowserstacksignuppage.verifyPageLoaded(wait);
        objbrowserstacksignuppage.verifyHeader();
        objbrowserstacksignuppage.enterUserName();
        objbrowserstacksignuppage.enterBusinessEmail();
        objbrowserstacksignuppage.enterpassword();
    }

}
