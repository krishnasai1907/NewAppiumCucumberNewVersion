package StepDefs;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class LoginPage {
    DesiredCapabilities cap;
    AndroidDriver driver;

    @Given("^User initiates the appium driver$")
    public void Userinitiatestheappiumdriver() {
        cap = new DesiredCapabilities();
        cap.setCapability("udid", "b3e31401");
        cap.setCapability("platformName", "android");
    }

    @When("User provides the App Package {string}")
    public void userProvidesTheAppPackage(String appPackage) {
        cap.setCapability("appPackage", appPackage);
    }

    @And("User provides the App Activity {string}")
    public void userProvidesTheAppActivity(String appActivity) throws Exception {
        cap.setCapability("appActivity", appActivity);
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        driver = new AndroidDriver(url, cap);
        System.out.println("Heey its working...");
    }

    @Then("User login with {string} and {string}")
    public void userLoginWithAnd(String username, String password) throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000));
        TouchActions touch = new TouchActions(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text='Choose Language']")));
        System.out.println("Home Page Value:" + driver.findElement(By.xpath("//android.widget.TextView[@text='Choose Language']")).getText());
        driver.findElement(AppiumBy.ByAndroidUIAutomator.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"English\"))")).click();
        driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.Button[@text='CONTINUE']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.Button[@text='NONE OF THE ABOVE']"))).click();
        Thread.sleep(2000);
        driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.TextView[@text='Use Email-ID']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.EditText[@text='Email ID']"))).sendKeys(username);
        driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.TextView[@text='Continue']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.EditText[@text='Password']"))).sendKeys(password);
        driver.findElement(AppiumBy.ByAndroidUIAutomator.xpath("//android.widget.TextView[@text='Continue']")).click();
    }

    @Then("User close the Application")
    public void userCloseTheApplication() {
        driver.quit();
    }
}
