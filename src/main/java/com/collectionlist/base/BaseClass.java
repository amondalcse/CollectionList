package com.collectionlist.base;
import static com.collectionlist.utility.PropertyFileReader.config;

import com.aventstack.extentreports.ExtentTest;
import com.collectionlist.utility.PropertyFileReader;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass
{

    public static  Properties prop;
    public static WebDriver driver;
    public static ExtentTest test;

   @BeforeTest
   @Parameters({"os","browser"})
    public void launchBrowser(String os, String browser) throws MalformedURLException {

       ChromeOptions co= new ChromeOptions();
       co.setBrowserVersion("115");
        //WebDriverManager.chromedriver().setup();
       //Load Object and Text properties
        PropertyFileReader.loadProperties();
        System.out.println("TESTTTTT");
        //OS for grid concept
       if(config.getProperty("execution_env").equalsIgnoreCase("remote")){
           DesiredCapabilities cap = new DesiredCapabilities();
           if(os.equalsIgnoreCase("window")){
               cap.setPlatform(Platform.WIN11);
           }
           else if(os.equalsIgnoreCase("mac")){
               cap.setPlatform(Platform.MAC);
           }
           else{
               System.out.println("No OS Selected");
               return;
           }

           //browser
           if(browser.equalsIgnoreCase("chrome")){

               cap.setBrowserName("chrome");
           }
           else if(browser.equalsIgnoreCase("safari")){
               cap.setBrowserName("safari");
           }
           else{
               System.out.println("No OS browser");
               return;
           }
           driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
           String baseUrl = config.getProperty("url");
           driver.get(baseUrl);
       }

       //
        //String browserName = config.getProperty("browser");
       if(config.getProperty("execution_env").equalsIgnoreCase("local")) {
           if (browser.equalsIgnoreCase("Chrome")) {

               driver = new ChromeDriver();
           } else if (browser.equalsIgnoreCase("Firefox")) {
               driver = new FirefoxDriver();
           } else {
               driver = new SafariDriver();
           }

           driver.manage().window().maximize();
           driver.manage().deleteAllCookies();
           //driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitWait")), TimeUnit.SECONDS);
           //driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTimeouts")),TimeUnit.SECONDS);
           //driver.get(prop.getProperty("url"));
           // PropertyFileReader.loadProperties();
           //launch the base url
           String baseUrl = config.getProperty("prod_url");
           driver.get(baseUrl);
       }
    }
    @AfterTest
    public void closeBrowser()
    {
        //close the browser or browser current tab

        driver.close();

        //terminate the broswer or close all the open broswer

        //driver.quit();
    }


}
