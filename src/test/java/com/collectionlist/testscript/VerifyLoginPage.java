package com.collectionlist.testscript;

import com.collectionlist.base.BaseClass;
import com.collectionlist.pages.Loginpage;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class VerifyLoginPage extends BaseClass
{
    //creating a LoginPage Instance
    static Loginpage login;

    @Test(priority=0 ,enabled = true, description = "Invalid login")
    @Parameters({"VALIDMOBNUMBER","INVALIDOTP"})
    public void invalidLogin(String mobileNumber, String mobileOtp ) throws Exception {
        login = new Loginpage(driver);
        login.enterMobileNumber(driver, mobileNumber);
        Thread.sleep(5000);
        login.clickVerifyWithOtp(driver);
        Thread.sleep(3000);
        login.enterOtp(driver, mobileOtp);
        Thread.sleep(5000);
        login.verifyInvalidOtpErrorMessage(driver);
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);

    }
    @Test(priority=2 ,enabled = true, description = "Successfully login to the portal")
    @Parameters({"VALIDMOBNUMBER","VALIDOTP"})
    public void successfullyLogin(String mobileNumber, String mobileOtp ) throws Exception {
        login = new Loginpage(driver);
        driver.navigate().refresh();
        login.enterMobileNumber(driver, mobileNumber);
        Thread.sleep(5000);
        login.clickVerifyWithOtp(driver);
        Thread.sleep(3000);
        login.enterOtp(driver, mobileOtp);

    }
    @Test(priority=1 , enabled = true,description = "Check the button is enable or disable")
    @Parameters({"INVALIDMOBNUMBER"})
    public void checkTheButtonIsEnableOrDisabled(String mobileNumber ) throws Exception {
        login = new Loginpage(driver);
        login.enterMobileNumber(driver, mobileNumber);
        Thread.sleep(5000);
        login.CheckverifyWithOTPButtonEnabledOrDisabled(driver);


    }

    }
