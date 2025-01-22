package com.collectionlist.testpractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

public class Base
{
    WebDriver driver;

    @BeforeMethod
    @Parameters({"browser"})
    public void openBrowser(String br) throws InterruptedException {
        if(br.contains("chrome")) {
            driver = new ChromeDriver();
            Thread.sleep(2000);
        }
        else if(br.contains("safari"))
        {
            driver= new SafariDriver();
            Thread.sleep(2000);
        }
        else{
            driver= new FirefoxDriver();
        }
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}
