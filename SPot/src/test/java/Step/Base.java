package Step;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Base {
    public static AndroidDriver<MobileElement> driver;

    public AndroidDriver initializeDriver() throws MalformedURLException {
        //Scanner input = new Scanner(System.in);
        DesiredCapabilities cap= new DesiredCapabilities();
        cap.setCapability("deviceName","Redmi 5A" );
        cap.setCapability("udid", "83885da7d840");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "7.1.2");
        cap.setCapability("appPackage", "com.spotify.music");
        cap.setCapability("appActivity", "com.spotify.music.MainActivity");
        cap.setCapability("noReset", "true");
        URL url = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(url,cap);
       // WebDriverWait wait = new WebDriverWait(driver,50);


        System.out.println("Application Started");
        return driver;
    }
}
