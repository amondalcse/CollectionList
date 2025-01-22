package com.collectionlist.testscript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.manager.SeleniumManager;

public class launch
{

    public static void main(String[] args) {
        ChromeOptions co = new ChromeOptions();
        /*String driverPath = SeleniumManager.getInstance().getDriverPath(co,false).driverPath;
        System.out.println(driverPath);

        String browserPath = SeleniumManager.getInstance().getDriverPath(co, false).browserPath;
        System.out.println(browserPath);*/

        co.setBrowserVersion("115");
       // co.setBinary("/Users/abhijitmondal/.cache/selenium/chromedriver/mac-x64/116.0.5845.96/chromedriver.exe");
        //System.setProperty("webdriver.chrome.driver","/Users/abhijitmondal/.cache/selenium/chromedriver/mac-x64/116.0.5845.96/chromedriver.exe");
          WebDriver driver = new ChromeDriver(co);
          driver.manage().window().maximize();
         driver.get("https://www.google.com");
        String url = driver.getCurrentUrl();
        String title=driver.getTitle();
        System.out.println(title);
        System.out.println(url);
        driver.close();
    }
}
