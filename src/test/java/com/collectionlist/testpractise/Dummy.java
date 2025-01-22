package com.collectionlist.testpractise;

import com.collectionlist.dataprovider.DataProviders;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dummy extends Base {

    //WebDriver driver;


    @Test(dataProvider = "LoginData")
    public void verifyLogin(String email, String password){
        driver.findElement(By.name("user-name")).clear();
        driver.findElement(By.name("user-name")).sendKeys(email);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        String error_msg=  driver.findElement(By.xpath("//div[@class='error-message-container error']/h3")).getText();
        Assert.assertEquals(error_msg,"Epic sadface: Username and password do not match any user in this service" );
        //Epic sadface: Username and password do not match any user in this service
    }


    @DataProvider(name="LoginData", indices = {0,2})
    Object[][]  loginData(){
        Object[][] data= {
                {"abcdhfg","qweyut2"},
                {"hdfghdgf","654653"},
                {"hgfhg","3654gw"}
        };
        return data;
    }


}
