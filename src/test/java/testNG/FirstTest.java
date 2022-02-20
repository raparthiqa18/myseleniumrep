package testNG;

import org.testng.annotations.*;


public class FirstTest {

    @BeforeTest
    public void launchapplication(){
        System.out.println("Application launched");
    }

    @BeforeMethod
    public void navigatetourl(){
        System.out.println("Navigated to url");
    }

    @Test(priority = 1, description = "Login test")
    public void login(){
        System.out.println("login successful");
    }

    @Test(priority = 2, description = "Logout test")
    public void logout(){
        System.out.println("logout successful");
    }

    @AfterMethod
    public void logoutapplication(){
        System.out.println("Application logged out");
    }

    @AfterTest
    public void Closeapplication(){
        System.out.println("Application closed");
    }


//    @Test(priority = 4)
//    public void Secondfasttest(){
//        System.out.println("Second fast test");
//    }
//
//    @Test(priority = 2)
//    public void fasttest(){
//        System.out.println("first fast test");
//    }
//
//    @Test(priority = 1, groups = "fastTest")
//    public void Thirdfasttest(){
//        System.out.println("Third fast test");
//    }
//
//    @Test(priority = 5, groups = "SlowTest")
//    public void Firstslowtest(){
//        System.out.println("first slow test");
//    }


}
