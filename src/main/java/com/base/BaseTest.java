package com.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver driver;
    private static ThreadLocal <WebDriver> DRIVER_CONTAINER = new ThreadLocal<WebDriver>();

    @BeforeClass
    public static void setupDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DRIVER_CONTAINER.set(driver);

    }

    public static WebDriver getDriver(){
        return DRIVER_CONTAINER.get();
    }

    @AfterMethod
    public void quit(){

        if (driver !=null){
            //driver.manage().deleteAllCookies();
            driver.quit();
            DRIVER_CONTAINER.remove();
        }
    }
}
