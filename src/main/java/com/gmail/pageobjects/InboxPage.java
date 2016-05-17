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

    public void composeClick(WebDriver driver) {
        WebElement composeClick = driver.findElement(By.cssSelector("button[role=\"menuitem\"][class=\"y hC\"]"));
        composeClick.click();
    }

    public void enterRecepient(WebDriver driver,String r) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class=\"tb\"]")));
        WebElement recepient = driver.findElement(By.cssSelector("input[placeholder=\"To\"][role=\"combobox\"]"));
        recepient.sendKeys(r);
    }

    public void enterSubject(WebDriver driver, String subject) {
        WebElement subjectTextArea = driver.findElement(By.cssSelector("input[placeholder=\"Subject\"]"));
        subjectTextArea.clear();
        subjectTextArea.sendKeys(subject);
    }

    public void enterBody(WebDriver driver, String body) {
        WebElement content = driver.findElement(By.cssSelector("div[aria-label=\"Body, Say something\"]"));
        content.clear();
        content.sendKeys(body);
    }

    public void clickSend(WebDriver driver) {
        WebElement sendClick = driver.findElement(By.cssSelector("div[class=\"sY dy Go qj\"][role=\"button\"]"));
        sendClick.click();
    }

    public void clickEmail(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class=\"p6\"]")));
        //8. Click email
        WebElement emailReceived = driver.findElement(By.cssSelector("span[email=\"davidcarvalho8421@gmail.com\"]"));
        emailReceived.click();
    }

    public String getSubject(WebDriver driver) {
        WebElement subjectArea = driver.findElement(By.cssSelector("span[class=\"eo xJNT8d\"]"));
        return subjectArea.getText();
    }

    public String getBody(WebDriver driver) {
        WebElement contentArea = driver.findElement(By.cssSelector("div[dir=\"ltr\"]"));
        return contentArea.getText();
    }
}

