package com.collectionlist.pages;

import com.collectionlist.actiondriver.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
//import org.testng.Assert;

import java.util.logging.Logger;

import static com.collectionlist.utility.PropertyFileReader.OR;
import static com.collectionlist.utility.PropertyFileReader.TextProp;

public class Loginpage
{
    public WebDriver driver;

    // For Logging
    //public Logger log = Logger.getLogger(this.getClass().getName());

    // Page constructor
    public Loginpage(WebDriver driver){
        this.driver = driver;
    }

    //************************************************Login Locator*********************************
    By enter_mobile_no = By.xpath(OR.getProperty("enter_mobile_no_XPATH"));
    By click_verify_with_security_pin= By.xpath(OR.getProperty("verify_with_security_pin_XPATH"));
    By click_verify_with_otp= By.xpath(OR.getProperty("verify_with_otp_XPATH"));
    By enter_otp= By.xpath(OR.getProperty("enter_otp_XPATH"));
    By click_complete_button= By.xpath(OR.getProperty("complete_button_XPATH"));
    By invalid_otp_error_message= By.xpath(OR.getProperty("invalid_otp_error_message_XPATH"));
    By check_disabled_button_verify_with_otp= By.xpath(OR.getProperty("verify_with_security_pin_disabled_XPATH"));
    //***********************************************************************************************

    public Loginpage enterMobileNumber(WebDriver driver,String mobNumber) throws Exception{

        Action.typeElement(driver,enter_mobile_no,mobNumber);
        return new Loginpage(driver);
    }
    public Loginpage clickSecuritypinButton(WebDriver driver ) throws Exception{

        Action.clickElement(driver,click_verify_with_security_pin,"Clicked Security Pin button");
        return new Loginpage(driver);
    }
    public Loginpage clickVerifyWithOtp(WebDriver driver ) throws Exception{

        Action.clickElement(driver,click_verify_with_otp,"Clicked otp button");
        return new Loginpage(driver);
    }
    public Loginpage enterOtp(WebDriver driver, String mobileOtp) throws Exception{

        Action.typeElement(driver,enter_otp,mobileOtp);
        return new Loginpage(driver);
    }
    public Loginpage clickCompleteButton(WebDriver driver ) throws Exception{

        Action.clickElement(driver,click_complete_button,"Clicked Complete button");
        return new Loginpage(driver);
    }

    public Loginpage verifyInvalidOtpErrorMessage(WebDriver driver) throws Exception {

        //Verify Invalid otp error message
        Assert.assertEquals(Action.getElementText(driver,invalid_otp_error_message ), TextProp.getProperty("invalidOtpErrorMessage"));

        //Verify Invalid Password  error message
        //Assert.assertEquals(UIFunctions.getElementText(driver, LoginPasswordErrorMessage),TextProp.getProperty("LoginEmailPwdErrorMessage"));

        return new Loginpage(driver);
    }
    public Loginpage CheckverifyWithOTPButtonEnabledOrDisabled(WebDriver driver ) throws Exception{

            //Action.isEnabled(driver,click_verify_with_otp);
            ;
            Assert.assertFalse(Action.isEnabled(driver,check_disabled_button_verify_with_otp));
            //Assert.assertFalse(Action.isElementEnabled(check_disabled_button_verify_with_otp,driver));
        return new Loginpage(driver);
    }



}
