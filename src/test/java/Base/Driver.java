package Base;

import com.google.common.io.Files;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.util.Date;

@Listeners(listener.Listener.class)
public class Driver {
    public static WebDriver driver;
    public WebDriverWait wait;

    @BeforeClass
    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/shanmugapriya/Downloads/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
        driver.manage().deleteAllCookies();
    }

    @BeforeMethod
    public void setURL() {
        driver.get("http://spree-vapasi.herokuapp.com");
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".nav-link.text-white")));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void takeSnapShot(WebDriver webdriver, String fileWithPath) throws IOException {
        Date d = new Date();
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        try {
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("/Users/shanmugapriya/Documents/SpreeSelenium/src/screenshots" + this.getClass().getName() + "_" + d + "_screenshot.png");
            Files.copy(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}