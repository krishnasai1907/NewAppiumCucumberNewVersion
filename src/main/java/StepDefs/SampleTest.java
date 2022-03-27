package StepDefs;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.net.URL;
import java.time.Duration;

public class SampleTest {
    static DesiredCapabilities cap;
    static AndroidDriver driver;

    public static void main(String[] args) throws Exception {
        cap = new DesiredCapabilities();
        cap.setCapability("udid", "b3e31401");
        cap.setCapability("platformName", "android");
        cap.setCapability("appPackage", "com.flipkart.android");
        cap.setCapability("appActivity", "com.flipkart.android.SplashActivity");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, cap);
        System.out.println("Heey its working...");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
        TouchActions touch = new TouchActions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Choose Language']")));
        System.out.println("Home Page Value:" + driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.TextView[@text='Choose Language']")).getText());
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"English\"))")).click();
//        driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.Button[@text='CONTINUE']")).click();
//        touch.click(driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.Button[@text='CONTINUE']"))).build().perform();
//        driver.findElement(AppiumBy.androidUIAutomator(""));
        touch.click(driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.Button[@text='CONTINUE']"))).build().perform();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.Button[@text='NONE OF THE ABOVE']"))).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.TextView[@text='Use Email-ID']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.EditText[@text='Email ID']"))).sendKeys("krishnasai1907@gmail.com");
        driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.TextView[@text='Continue']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.EditText[@text='Password']"))).sendKeys("1907krishnasai");
        driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.TextView[@text='Continue']")).click();
        driver.quit();
    }
}
