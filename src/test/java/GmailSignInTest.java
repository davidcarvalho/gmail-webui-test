import com.gmail.pageobjects.InboxPage;
import com.gmail.pageobjects.SignInPage;
import com.gmail.util.WebUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * Created by David.Carvalho on 15-01-2016.
 */
public class GmailSignInTest {

    //Instantiate
    private WebDriver driver = new FirefoxDriver();
    private WebDriverWait wait = new WebDriverWait(driver,20);

    @Test
    public void gmailLoginSuccessful(){

        //go to gmail
        SignInPage signInPage = WebUtils.goToSignInPage(driver);

        //username
        signInPage.enterUsername(driver,"davidcarvalho8421@gmail.com");

        //Next
        signInPage.clickNext(driver);

        //password
        signInPage.enterPassword(driver,"$hrek8421");

        //click sign in
        InboxPage inboxPage = signInPage.clickSignIn(driver);

        //Verify sign in
        Assert.assertTrue("Inbox should exist", inboxPage.isInboxExist(driver));

        //sign out
        signInPage = inboxPage.signOut(driver);

        //verify sign out
        Assert.assertTrue("Sign in button should exist",signInPage.isSignInExist(driver));
    }

    @Test
    public void gmailSendEmail() {
        //1.Sign In
        //go to gmail
        SignInPage signInPage = WebUtils.goToSignInPage(driver);

        //username
        signInPage.enterUsername(driver,"davidcarvalho8421@gmail.com");

        //Next
        signInPage.clickNext(driver);

        //password
        signInPage.enterPassword(driver,"$hrek8421");

        //click sign in
        InboxPage inboxPage = signInPage.clickSignIn(driver);

        //Verify sign in
        Assert.assertTrue("Inbox should exist", inboxPage.isInboxExist(driver));

        //2.Click compose
        inboxPage.composeClick(driver);

        //3. Enter To
        inboxPage.enterRecepient(driver,"davidcarvalho8421@gmail.com");

        //4. Subject
        final String subject = "Hello selenium";
        inboxPage.enterSubject(driver,subject);

        //5. Enter body
        final String body = "Say something stupid";
        inboxPage.enterBody(driver,body);

        //6. Click send
        inboxPage.clickSend(driver);

        //7. Click email
        inboxPage.clickEmail(driver);

        //9. Verify email subject and body is correct
        String actualSubject = inboxPage.getSubject(driver);
        Assert.assertEquals("Email subject should be the same",subject,actualSubject);
        String actualBody = inboxPage.getBody(driver);
        Assert.assertEquals("Email subject should be the same",body,actualBody);

        //10. Sign out
        inboxPage.signOut(driver);
    }
    @After
    public void tearDown(){

        driver.quit();
    }

}
