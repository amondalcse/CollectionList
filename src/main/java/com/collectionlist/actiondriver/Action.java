package com.collectionlist.actiondriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;


import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static com.collectionlist.base.BaseClass.driver;
import static com.collectionlist.listners.ExtentManager.fileSeperator;


public class Action {
    public static String rootDir = Action.getRootDirectory();
    public static Logger log = Logger.getLogger(Action.class.getName());

    /**
     * @param driver
     * @param by
     * @param eleName
     * @Author: Abhijit Mondal
     * @Description: this method is used to click the element
     */
    public static void clickElement(WebDriver driver, By by, String eleName) {
        try {
            driver.findElement(by).click();
            log.info("Successfully clicked on element:---> \n" + eleName);
            Reporter.log("<P>Successfully clicked on element:---> \n" + eleName);
        } catch (NoSuchElementException e) {
            log.info("element to clicked not present:---> \n" + e);
            Reporter.log("<P>element to clicked not presentt:---> \n" + e);
        }

    }

    /**
     * @param driver
     * @param by
     * @param ele
     * @Description: this method is used to enter the data into the field
     * @auther:Abhijit Mondal
     */
    public static void typeElement(WebDriver driver, By by, String ele) {
        try {
            //driver.findElement(by).clear();
            driver.findElement(by).sendKeys(ele);
            log.info("Successfully entered the element:---> \n" + ele);
            Reporter.log("<P>Successfully entered the element:---> \n" + ele);
        } catch (NoSuchElementException e) {
            log.info("Element not entered:---> \n" + e);
            Reporter.log("<P>Element not entered:---> \n" + e);
        }
    }

    /**
     * @param driver
     * @param by
     * @param ele
     * @Description: this method is used to enter the data into the field
     * @auther:Abhijit Mondal
     */
    public static void typeStringElement(WebDriver driver, By by, WebElement ele) {
        try {
            driver.findElement(by).clear();
            driver.findElement(by).sendKeys("ele");
            log.info("Successfully entered the element:---> \n" + ele);
            Reporter.log("<P>Successfully entered the element:---> \n" + ele);
        } catch (NoSuchElementException e) {
            log.info("Element not entered:---> \n" + e);
            Reporter.log("<P>Element not entered:---> \n" + e);
        }
    }

    /**
     * @param driver
     * @Description: this method is used to back from the page using browser back
     * @Author:Abhijit Monddal
     */
    public static void navigateBack(WebDriver driver) {
        driver.navigate().back();

    }

    /**
     * @param by
     * @param driver
     * @return
     * @Description: this method is used to check element is present or not
     * @Author: Abhijit Mondal
     */
    public static boolean isElementPresent(By by, WebDriver driver) {
        try {
            // Verify element is present
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            log.info("No such element present--> \n" + e);
            Reporter.log("<p>No such element present");
            return false;
        }
    }

    /**
     * Method Name: mouseOverElement Description: This method used to mouseOver an element in the screen
     *
     * @param driver : WebDriver
     * @param ele    : WebElement locator
     * @Author: Abhijit Mondal
     */
    public static void mouseOverElement(WebDriver driver, WebElement ele)
            throws Exception {
        try {
            // Mouse hover/roll over on element
            Thread.sleep(5000);
            Actions builder = new Actions(driver);
            builder.moveToElement(ele).build().perform();

        } catch (NoSuchElementException e) {
            log.info("Element to mouse over is not present " + e);
            Reporter.log("<p>Element to mouse over is not present");

        }

    }

    /**
     * Method Name: selectDropDownValue_new Description: This method selects dropdown value
     *
     * @param ele           : DropDown webElement
     * @param dropDownValue : dropDown Value to be selected
     * @Author: Abhijit Mondal
     */
    public static void selectDropDownValue(WebElement ele, String dropDownValue, String optionType) throws Exception {
        try {
            // Dropdown in which value to be selected
            Select dropDown = new Select(ele);

            // Selecting dropdown value
            if (optionType.equalsIgnoreCase("text")) {
                dropDown.selectByVisibleText(dropDownValue);

            } else if (optionType.equalsIgnoreCase("value")) {
                dropDown.selectByValue(dropDownValue);
            }

        } catch (NoSuchElementException e) {
            log.info("Element to select drop down is not present " + e);
            Reporter.log("<p>Element to drop down is not present");

        }

    }

    /**
     * Method Name: getElementText
     * Description: This method retrieves the Text value of the specified element
     *
     * @param driver : WebDriver
     * @param by     : WebElement locator
     * @return
     * @Author: Abhijit Mondal
     */
    public static String getElementText(WebDriver driver, By by) throws Exception {
        String eleText = driver.findElement(by).getText();


        return eleText;
    }

    /**
     * Method Name: ImplictlyWait
     * Description: This method is used to Wait the till response will get.
     *
     * @param driver : WebDriver
     * @param :      WebElement locator
     * @Author: Abhijit Mondal
     */
    public static void ImplicitWait(WebDriver driver, int time) {
        driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    /**
     Method Name: WebDriverWait
     * Description: This method is used to Wait till that object  not clicked
     * @Author:Abhijit Mondal
     * @param driver  : WebDriver
     * @param by      : WebElement locator
     */

   /* public static void WebDriverWait(WebDriver driver,int time,By by)
    {
        WebDriverWait wait = new WebDriverWait(driver,time);

        wait.until(ExpectedConditions.elementToBeClickable(by));
    }*/

    //Few custom functions

    // public static String rootDir = Action.getRootDirectory();

    /**
     * Method Name: getRootDirectory
     * Description: Method to get Root directory
     *
     * @return :rootDir
     * @Author:Abhijit Mondal
     */

    public static String getRootDirectory() {
        File path = new File("");
        String absolPath = path.getAbsolutePath();
        File dir = new File(absolPath);
        String rootDir = dir.getParent();
        return rootDir;

    }

    /**
     * Method Name: refreshPage
     * Description: Method to used refresh a page
     *
     * @param driver:WebDriver
     * @return driver
     * @Author:Abhijit Mondal
     */
    public static WebDriver refreshPage(WebDriver driver) {

        driver.navigate().refresh();
        return (driver);
    }

    /**
     * This element verifies element is displayed or not
     *
     * @param element
     * @param driver
     * @return true: if element is visible, false : if element is not visible
     * @throws Exception
     * @Author:Abhijit Mondal
     */
    public static boolean isElementVisible(By element, WebDriver driver)
            throws Exception {
        try {
            driver.findElement(element).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Method name: stringSpilt
     * Description : for split the string by providing 'regex'(regular expression)
     *
     * @param str
     * @param regex
     * @return
     * @Author:Abhijit Mondal
     */
    public static String stringSpilt(String str, String regex) {
        String st[] = str.split(regex);
        String price = st[1];
		/*String str1=st[0].concat(st[1]);
		System.out.println(str1);*/
        return price;
    }

    /**
     * Method name: stringSpiltByComma
     * Description : for split the string by Camaa(,)
     *
     * @param str
     * @return
     * @Author:Abhijit Mondal
     */
    public static String stringSpiltByComma(String str) {
        String st[] = str.split(",");
        //String price=st[1];
        String str1 = (st[0].concat(st[1]));
        //System.out.println(str1);
        return str1;
    }

    /**
     * This element verifies element is displayed or not
     *
     * @param element
     * @param driver
     * @return true: if element is visible, false : if element is not visible
     * @throws Exception
     * @Author:Abhijit Mondal
     */
    public static boolean isElementDisplayed(By element, WebDriver driver)
            throws Exception {
        try {
            driver.findElement(element).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * This element verifies element is enabled or not
     *
     * @param element
     * @param driver
     * @return true: if element is enable, false : if element is not enabled
     * @throws Exception
     * @Author:Abhijit Mondal
     */

    public static boolean isElementEnabled(By element, WebDriver driver) {
        try {
            driver.findElement(element).isEnabled();
            return true;
        } catch (NoSuchElementException e) {
            System.out.println(e);
            return false;
        }
    }

    /**
     * This element verifies element is selected or not
     *
     * @param element
     * @param driver
     * @return true: if element is selected, false : if element is not selected
     * @throws Exception
     * @Author:Abhijit Mondal
     */

    public static boolean isElementSelected(By element, WebDriver driver) {
        try {
            driver.findElement(element).isSelected();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * This method user for scrolling web page using JavascriptExecutor interface
     *
     * @param
     * @param driver
     * @Author:Abhijit Mondal
     */

    public static void ScrollingWebPage(WebDriver driver, int value) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0," + value + ")", "");

    }

    public static void captureScreenshot(String methodName) {
        Date d = new Date();
        String timeStamp = d.toString().replace(":", "_").replace(" ", "");
        try {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File(System.getProperty("user.dir") + fileSeperator + "Screenshots" + fileSeperator + methodName + timeStamp + " .jpg"));
            log.info("Tc got failed " + methodName);
            Reporter.log("<p>Tc got failed" + methodName);
        } catch (IOException e) {
            e.getMessage();
            log.info("Tc got failed " + e);
            Reporter.log("<p>Tc got failed");
        }
    }

    public static boolean isEnabled(WebDriver driver, By by) {
        try{
            WebElement el = driver.findElement(by);
            System.out.println("Is button is enabled: " + el.isEnabled());
            return true;
        }
        catch( Exception e) {

            return false;
        }

    }

}




