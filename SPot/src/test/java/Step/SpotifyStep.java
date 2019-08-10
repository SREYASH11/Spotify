package Step;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;


public class SpotifyStep extends Base {


    @Given("^Application is opened$")
    public void Application_is_opened() throws MalformedURLException {
        initializeDriver();
        System.out.println("helooooooooooooooooooooooooo");
        MobileElement element = driver.findElementById("android:id/text1");
        String elText = element.getText();
        if (elText == "Recently played") {
            System.out.println("\n=============\nAt Home Screen");

        }
    }

    @When("^I choose song from Recently played playlist$")
    public void iChooseSongFromRecentlyPlayedPlaylist() {
        WebElement banner = driver.findElementByAndroidUIAutomator("text(\"UnderCover\")");
        Point bannerPoint = banner.getLocation();
        // Get size of device screen
        Dimension screenSize = driver.manage().window().getSize();
        // Get start and end coordinates for horizontal swipe
        int startX = Math.toIntExact(Math.round(screenSize.getWidth() * 0.8));
        int endX = 0;

        TouchAction action = new TouchAction(driver);
        action
                .press(PointOption.point(startX, bannerPoint.getY()))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(endX, bannerPoint.getY()))
                .release();
        driver.performTouchAction(action);
    }

    @Then("^Song is played$")
    public void songIsPlayed() {
        MobileElement element = driver.findElementById("com.spotify.music:id/playPause");

        String elText = element.getAttribute("content-desc");
        System.out.println("\n==============="+elText+"========================");

    }

    @Given("^Application is on search menu$")
    public void applicationIsOnSearchMenu() throws MalformedURLException {
        initializeDriver();
        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Search\"]"))).click();
        //validate if cursor is at right destination
        MobileElement element = driver.findElementById("com.spotify.music:id/header_title");

        String elText = element.getText();
        System.out.println(elText);
        if (elText.contains("Search")) {
            System.out.println("\n=============\nAt Search Screen");
        }
    }

    @When("^I enter \"([^\"]*)\" to search song$")
    public void iEnterToSearchSong(String Text) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver,50);
        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Search your downloads\"]").click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.EditText[@index='1']"))).sendKeys(Text, Keys.ENTER);

    }

    @Then("^I will choose song from list$")
    public void iWillChooseSongFromList() {
        WebDriverWait wait = new WebDriverWait(driver,50);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@index='0']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@text=\"SHUFFLE PLAY\"]"))).click();
    }
}

