import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

    @Test
    public void gmailLoginSuccessful(){

        //go to gmail
        driver.get("http://gmail.com");
        //username
        WebElement usernameTxtBox = driver.findElement(By.xpath(".//*[@id='Email']"));
        usernameTxtBox.clear();
        usernameTxtBox.sendKeys("davidcarvalho8421@gmail.com");
        //Next
        WebElement nextButton = driver.findElement(By.xpath(".//*[@id='next']"));
        nextButton.click();
        //password
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Passwd']")));
        WebElement passwdTxtBox = driver.findElement(By.xpath("//*[@id='Passwd']"));
        passwdTxtBox.clear();
        passwdTxtBox.sendKeys("$hrek8421");
        //click sign in
        WebElement signinButton = driver.findElement(By.xpath("//*[@id='signIn']"));
        signinButton.click();
        //verify sign in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fv']")));
        Assert.assertTrue("Not logged in", driver.findElements(By.partialLinkText("Gmail")).size() > 0);
        //sign out
        WebElement profileClick = driver.findElement(By.cssSelector("span[class=\"gb_2a gbii\"]"));
        profileClick.click();
        WebElement signOut = driver.findElement(By.xpath(".//*[@id='gb_71']"));
        signOut.click();
        //verify sign out
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signIn']")));
        Assert.assertTrue("Not signed out", driver.findElements(By.xpath("//*[@id='Passwd']")).size() > 0);
    }

    @Test
    public void gmailSendEmail() {
        //1.Sign In
        //go to gmail
        driver.get("http://gmail.com");
        //username
        WebElement usernameTxtBox = driver.findElement(By.xpath(".//*[@id='Email']"));
        usernameTxtBox.clear();
        usernameTxtBox.sendKeys("davidcarvalho8421@gmail.com");
        //Next
        WebElement nextButton = driver.findElement(By.xpath(".//*[@id='next']"));
        nextButton.click();
        //password
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='Passwd']")));
        WebElement passwdTxtBox = driver.findElement(By.xpath("//*[@id='Passwd']"));
        passwdTxtBox.clear();
        passwdTxtBox.sendKeys("$hrek8421");
        //click sign in
        WebElement signinButton = driver.findElement(By.xpath("//*[@id='signIn']"));
        signinButton.click();
        //verify sign in
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='fv']")));
        Assert.assertTrue("Not logged in", driver.findElements(By.partialLinkText("Gmail")).size() > 0);
        //wait for page load
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        //2.Click compose
        WebElement composeClick = driver.findElement(By.cssSelector("button[role=\"menuitem\"][class=\"y hC\"]"));
        composeClick.click();

        //3. Enter To
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img[class=\"tb\"]")));
        WebElement recepient = driver.findElement(By.cssSelector("input[placeholder=\"To\"][role=\"combobox\"]"));
        recepient.sendKeys("davidcarvalho8421@gmail.com");
        //4. Subject
        WebElement subjectTextArea = driver.findElement(By.cssSelector("input[placeholder=\"Subject\"]"));
        final String subject = "Hello selenium";
        subjectTextArea.clear();
        subjectTextArea.sendKeys(subject);
        //5. Enter something
        WebElement content = driver.findElement(By.cssSelector("div[aria-label=\"Body, Say something\"]"));
        final String body = "Say something stupid";
        content.clear();
        content.sendKeys(body);
        //6. Click send
        WebElement sendClick = driver.findElement(By.cssSelector("div[class=\"sY dy Go qj\"][role=\"button\"]"));
        sendClick.click();
        //7. Sync Inbox
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[class=\"p6\"]")));
        //8. Click email
        WebElement emailReceived = driver.findElement(By.cssSelector("span[email=\"davidcarvalho8421@gmail.com\"]"));
        emailReceived.click();
        //9. Verify email subject and body is correct
        WebElement subjectArea = driver.findElement(By.cssSelector("span[class=\"eo xJNT8d\"]"));
        Assert.assertEquals("Email subject should be the same",subject,subjectArea.getText());
        WebElement contentArea = driver.findElement(By.cssSelector("div[dir=\"ltr\"]"));
        Assert.assertEquals("Email subject should be the same",body,contentArea.getText());
        //10. Sign out
        WebElement profileClick = driver.findElement(By.cssSelector("span[class=\"gb_2a gbii\"]"));
        profileClick.click();
        WebElement signOut = driver.findElement(By.xpath(".//*[@id='gb_71']"));
        signOut.click();
        //verify sign out
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signIn']")));
        Assert.assertTrue("Not signed out", driver.findElements(By.xpath("//*[@id='Passwd']")).size() > 0);
    }
    @After
    public void tearDown(){

        driver.quit();
    }

}
