package com.appframework.util;

import com.appframework.pageobjects.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by David.Carvalho on 16-05-2016.
 */
public class WebUtils {


    public static SignInPage goToSignInPage(WebDriver driver) {
        driver.get("http://gmail.com");
        return PageFactory.initElements(driver, SignInPage.class);
    }

    public static void click(WebDriver driver, By by) {
        WebElement webelement = driver.findElement(by);
        webelement.click();
    }

    public static void waitTillElementExist(WebDriver driver, By by) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public static boolean isElementExist(WebDriver driver, By by) {
        return driver.findElements(by).size()>0;
    }

    public static void enterText(WebDriver driver, By by, String text) {
        WebElement webelement = driver.findElement(by);
        webelement.clear();
        webelement.sendKeys(text);
    }

    public static String getText(WebDriver driver, By by) {
        WebElement webelement = driver.findElement(by);
        return webelement.getText();
    }
}
