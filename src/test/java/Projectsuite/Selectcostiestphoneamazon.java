package Projectsuite;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.*;

public class Selectcostiestphoneamazon extends TestBase {
    public static void main(String[] args) throws InterruptedException {
        launchBrowser("chrome");
        driver.get("https://www.amazon.in/s?k=iphone+13&crid=1LU9XRLF4SIT2&sprefix=iphone+1%2Caps%2C287&ref=nb_sb_noss_2");

        try{
            List<WebElement> listofphones=driver.findElements(getObjectlocator("iphonename_cssSelector"));
            List<WebElement> iphoneprice=driver.findElements(getObjectlocator("iphonepricetag_xpath"));

            System.out.println(listofphones.size() + " " + iphoneprice.size());
            HashMap<Integer, String> map_finalproducts=new HashMap<Integer, String>();
            String product_name;
            String product_price;
            int int_product_price;

            for (int i=0; i<listofphones.size(); i++){
                product_name=listofphones.get(i).getText();
                product_price=iphoneprice.get(i).getText();
                int_product_price= Integer.parseInt(product_price.replaceAll("[^0-9]",""));
                map_finalproducts.put(int_product_price,product_name);
            }
            System.out.println(map_finalproducts.size());
            System.out.println(map_finalproducts);
            //get all keys from hashmap
            Set<Integer> allkeys=map_finalproducts.keySet();
            ArrayList<Integer> array_list_values_product_prices = new ArrayList<Integer>(allkeys);
            Collections.sort(array_list_values_product_prices);
            System.out.println("Price " + array_list_values_product_prices);
            int highestprice=array_list_values_product_prices.get(array_list_values_product_prices.size()-1);
            int lowestprice=array_list_values_product_prices.get(0);

            System.out.println(map_finalproducts.get(highestprice));
            System.out.println(map_finalproducts.get(lowestprice));

        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            Thread.sleep(2000);
            driver.quit();
        }
    }

    public static By getObjectlocator(String locatorkey){
        if(locatorkey.endsWith("_id")){
            return By.id(prop.getProperty(locatorkey));
        }else if(locatorkey.endsWith("_cssSelector")){
            return By.cssSelector(prop.getProperty(locatorkey));
        }else if(locatorkey.endsWith("_xpath")){
            return By.xpath(prop.getProperty(locatorkey));
        }else if(locatorkey.endsWith("_linkText")){
            return By.linkText(prop.getProperty(locatorkey));
        }else{
            return By.className(prop.getProperty(locatorkey));
        }
    }

    public static boolean isElementPresent(String locatorkey){

        By locator=getObjectlocator(locatorkey);

        // Clickable, Visible, Presence
        try{
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        }catch(Exception e){
            e.printStackTrace();

        }
        return false;
    }
}
