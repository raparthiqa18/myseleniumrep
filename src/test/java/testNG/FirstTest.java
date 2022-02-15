package testNG;

import org.testng.annotations.Test;

public class FirstTest {


    @Test(priority = 4)
    public void Secondfasttest(){
        System.out.println("Second fast test");
    }

    @Test(priority = 2)
    public void fasttest(){
        System.out.println("first fast test");
    }

    @Test(priority = 1, groups = "fastTest")
    public void Thirdfasttest(){
        System.out.println("Third fast test");
    }

    @Test(priority = 5, groups = "SlowTest")
    public void Firstslowtest(){
        System.out.println("first slow test");
    }


}
