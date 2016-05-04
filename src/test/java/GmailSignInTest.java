import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by David.Carvalho on 15-01-2016.
 */
public class GmailSignInTest {

    //Instantiate
    WebDriver driver = new FirefoxDriver();

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
    @After
    public void tearDown(){

        driver.quit();
    }
}
