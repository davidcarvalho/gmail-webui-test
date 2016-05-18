package com.appframework.pageobjects;

import com.appframework.util.WebUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by David.Carvalho on 16-05-2016.
 */
public class InboxPage {
    public SignInPage signOut(WebDriver driver) {
        WebUtils.click(driver,By.cssSelector("span[class=\"gb_2a gbii\"]"));
        WebUtils.click(driver,By.xpath(".//*[@id='gb_71']"));
        WebUtils.waitTillElementExist(driver,By.xpath("//*[@id='signIn']"));
        return PageFactory.initElements(driver,SignInPage.class);
    }

    public boolean isInboxExist(WebDriver driver) {
        return WebUtils.isElementExist(driver,By.partialLinkText("Gmail"));
    }

    public void composeClick(WebDriver driver) {
        WebUtils.click(driver,By.cssSelector("button[role=\"menuitem\"][class=\"y hC\"]"));
    }

    public void enterRecepient(WebDriver driver,String r) {
        WebUtils.waitTillElementExist(driver,By.cssSelector("img[class=\"tb\"]"));
        WebUtils.enterText(driver,By.cssSelector("input[placeholder=\"To\"][role=\"combobox\"]"),r);
    }

    public void enterSubject(WebDriver driver, String subject) {
        WebUtils.enterText(driver,By.cssSelector("input[placeholder=\"Subject\"]"),subject);
    }

    public void enterBody(WebDriver driver, String body) {
        WebUtils.enterText(driver,By.cssSelector("div[aria-label=\"Body, Say something\"]"),body);
    }

    public void clickSend(WebDriver driver) {
        WebUtils.click(driver,By.cssSelector("div[class=\"sY dy Go qj\"][role=\"button\"]"));
    }

    public void clickEmail(WebDriver driver) {
        WebUtils.waitTillElementExist(driver,By.cssSelector("span[class=\"p6\"]"));
        WebUtils.click(driver,By.cssSelector("span[email=\"davidcarvalho8421@gmail.com\"]"));
    }

    public String getSubject(WebDriver driver) {
        return WebUtils.getText(driver,By.cssSelector("span[class=\"eo xJNT8d\"]"));
    }

    public String getBody(WebDriver driver) {
        return WebUtils.getText(driver,By.cssSelector("div[dir=\"ltr\"]"));
    }
}

