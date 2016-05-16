package com.gmail.util;

import com.gmail.pageobjects.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by David.Carvalho on 16-05-2016.
 */
public class WebUtils {


    public static SignInPage goToSignInPage(WebDriver driver) {
        driver.get("http://gmail.com");
        return PageFactory.initElements(driver, SignInPage.class);
    }
}
