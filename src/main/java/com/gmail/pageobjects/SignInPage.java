package com.gmail.pageobjects;

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
        WebElement usernameTxtBox = driver.findElement(By.xpath(".//*[@id='Email']"));
        usernameTxtBox.clear();
        usernameTxtBox.sendKeys(username);
    }

    public void enterPassword(WebDriver driver, String password) {

        //wait
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Passwd']")));

        WebElement passwdTxtBox = driver.findElement(By.xpath("//*[@id='Passwd']"));
        passwdTxtBox.clear();
        passwdTxtBox.sendKeys(password);
    }

    public void clickNext(WebDriver driver) {
        WebElement nextButton = driver.findElement(By.xpath(".//*[@id='next']"));
        nextButton.click();
    }

    public InboxPage clickSignIn(WebDriver driver) {
        WebElement signinButton = driver.findElement(By.xpath("//*[@id='signIn']"));
        signinButton.click();

        //verify sign in
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fv']")));

        //wait for page load
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        return PageFactory.initElements(driver,InboxPage.class);
    }

    public boolean isSignInExist(WebDriver driver) {
        return  driver.findElements(By.xpath("//*[@id='Passwd']")).size() > 0;
    }
}
