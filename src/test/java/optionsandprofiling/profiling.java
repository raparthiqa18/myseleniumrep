package optionsandprofiling;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;

public class profiling {
    public static void main(String[] args) {

        /*Profile to manage:
        maximize browsers
        certificate errors
        work with proxy
        //Firefox profile

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\Desktop\\Rakesh\\Professional\\Automation\\geckodriver-v0.30.0-win64\\geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        //options.setPageLoadStrategy(strategy);
        options.setBinary("C:\\Program Files\\Mozilla Firefox\firefox.exe");
        ProfilesIni allProf=new ProfilesIni();
        FirefoxProfile firefoxProfile=allProf.getProfile("User");
        //notification
        firefoxProfile.setPreference("dom.webnotifications.enabled", false);
        //ssl
        firefoxProfile.setAcceptUntrustedCertificates(true);
        firefoxProfile.setAssumeUntrustedCertificateIssuer(false);
        //proxy

        FirefoxDriver driver=new FirefoxDriver();
        driver.get("https://google.com");
        */

       System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Rakesh\\Professional\\Automation\\chromedriver_win32\\chromedriver.exe");
       System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "target\\chromelog.log");
       System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--disable notifications");
        options.addArguments("--start-maxmized");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--headless");
        //options.headless = True; //also works
        options.addArguments("user-data-dir=C:\\Users\\USER\\AppData\\Local\\Google\\Chrome\\User Data");
        ChromeDriver driver=new ChromeDriver(options);
        driver.get("https://google.com");

//        System.setProperty("webdriver.edge.driver", "C:\\Users\\USER\\Desktop\\Rakesh\\Professional\\Automation\\edgedriver_win64\\msedgedriver.exe");
//        EdgeDriver driver=new EdgeDriver();
//        driver.get("https://google.com");


    }
}
