package com.collectionlist.testpractise;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Dummy1 extends Base
{
    /*WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    public void openBrowser(String br){

        if(br.contains("chrome"))
        {
            driver= new ChromeDriver();
        }
        else if(br.contains("firefox")){
            driver = new FirefoxDriver();
        }
        else {
            driver = new SafariDriver();
        }
        //driver= new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }*/

   /* @AfterClass
    public void closeBrowser(){
        driver.close();
    }*/

    @Test(priority = 0)
    public void scenario1(){
    String title = driver.getTitle();
    Assert.assertEquals(title,"Swag Labs");
    }

    @Test(priority = 1)
    public void scenario2()
    {
        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,"https://www.saucedemo.com/");

    }
}
