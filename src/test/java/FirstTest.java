import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FirstTest {
    public static void main(String[] args) {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Desktop\\Rakesh\\Professional\\Automation\\chromedriver_win32\\chromedriver.exe");
//        ChromeDriver driver=new ChromeDriver();
//        driver.get("https://google.com");

//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\USER\\Desktop\\Rakesh\\Professional\\Automation\\geckodriver-v0.30.0-win64\\geckodriver.exe");
//        FirefoxDriver driver=new FirefoxDriver();
//        driver.get("https://google.com");

//        System.setProperty("webdriver.edge.driver", "C:\\Users\\USER\\Desktop\\Rakesh\\Professional\\Automation\\edgedriver_win64\\msedgedriver.exe");
//        EdgeDriver driver=new EdgeDriver();
//        driver.get("https://google.com");

        //LocalDate localDate=LocalDate.now();
        String dob="2022-03-02";
        LocalDate localDate= LocalDate.parse(dob);
        System.out.println(localDate);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("dd")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("MMMM")));
        System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy")));
        System.out.println(localDate.compareTo(localDate.now()));


    }
}
