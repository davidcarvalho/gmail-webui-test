import com.appframework.categories.Critical;
import com.appframework.categories.Major;
import com.appframework.pageobjects.InboxPage;
import com.appframework.pageobjects.SignInPage;
import com.appframework.util.WebUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created by David.Carvalho on 15-01-2016.
 */
public class GmailSignInTest {

    //Instantiate
    private WebDriver driver;

    @Before
    public void setDriver(){
        String browserName = System.getenv("browser");
        if (browserName!=null && browserName.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
    }

    @Category({Critical.class})
    @Test
    public void gmailLoginSuccessful(){

        //go to gmail
        SignInPage signInPage = WebUtils.goToSignInPage(driver);

        //username
        signInPage.enterUsername(driver,"@gmail.com");

        //Next
        signInPage.clickNext(driver);

        //password
        signInPage.enterPassword(driver,"");

        //click sign in
        InboxPage inboxPage = signInPage.clickSignIn(driver);

        //Verify sign in
        Assert.assertTrue("Inbox should exist", inboxPage.isInboxExist(driver));

        //sign out
        signInPage = inboxPage.signOut(driver);

        //verify sign out
        Assert.assertTrue("Sign in button should exist",signInPage.isSignInExist(driver));
    }

    @Category({Major.class})
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
