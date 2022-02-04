package Advanced;

import base.TestBase;
import org.openqa.selenium.JavascriptExecutor;

public class Javascriptexecutorexercise extends TestBase {
    public static void main(String[] args) throws InterruptedException {

        launchBrowser("chrome");
        driver.get("https://google.com");

        try{
            //navigate to a url
            JavascriptExecutor js= (JavascriptExecutor) driver;
            js.executeScript("window.location='https://www.linkedin.com/login'");

            //operate on webelement
            js.executeScript("document.getElementById('username').value='test'");

            //scroll bar
            js.executeScript("window.scrollTo(0,100)");


        }catch(Exception e){
            e.printStackTrace();
        }finally {
            Thread.sleep(2000);
            driver.quit();
        }


    }

    public static void waitForPageToLoad() throws InterruptedException {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        int i=0;
        while(i!=10){
            String state=(String) js.executeScript("return document.readyState;");
            System.out.println(state);//complete, loading, interactive
            if(state.equals("complete")){
                break;
            }else{
                Thread.sleep(2000);
            }
            i++;
        }

        //Check for Jquery/Ajax
        i=0;
        while(i!=10){
            Long d=(Long)js.executeScript("return jQuery.active;");
            System.out.println(d);//0,1
            if(d.longValue() == 0){
                break;
            }else{
                Thread.sleep(2000);
            }
            i++;
        }

    }
}
