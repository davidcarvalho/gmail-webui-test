package com.gmail.pageobjects;

import com.gmail.util.WebUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by David.Carvalho on 16-05-2016.
 */
public class SignInPage {

    public void enterUsername(WebDriver driver, String username) {
        WebUtils.enterText(driver,By.xpath(".//*[@id='Email']"),username);
    }

    public void enterPassword(WebDriver driver, String password) {
        WebUtils.waitTillElementExist(driver,By.xpath("//*[@id='Passwd']"));
        WebUtils.enterText(driver,By.xpath(".//*[@id='Passwd']"),password);
    }

    public void clickNext(WebDriver driver) {
        WebUtils.click(driver,By.xpath(".//*[@id='next']"));
    }

    public InboxPage clickSignIn(WebDriver driver) {
        WebUtils.click(driver,By.xpath("//*[@id='signIn']"));
        WebUtils.waitTillElementExist(driver,By.xpath(".//*[@id='fv']"));
        //wait for page load
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        return PageFactory.initElements(driver,InboxPage.class);
    }

    public boolean isSignInExist(WebDriver driver) {
        return  WebUtils.isElementExist(driver,By.xpath("//*[@id='Passwd']"));
    }
}
