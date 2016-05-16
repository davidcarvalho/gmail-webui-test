package com.gmail.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by David.Carvalho on 16-05-2016.
 */
public class InboxPage {
    public SignInPage signOut(WebDriver driver) {
        WebElement profileClick = driver.findElement(By.cssSelector("span[class=\"gb_2a gbii\"]"));
        profileClick.click();
        WebElement signOut = driver.findElement(By.xpath(".//*[@id='gb_71']"));
        signOut.click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signIn']")));

        return PageFactory.initElements(driver,SignInPage.class);
    }

    public boolean isInboxExist(WebDriver driver) {
       return driver.findElements(By.partialLinkText("Gmail")).size()>0;
    }
}

