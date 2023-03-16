import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ChromeMobileTesting {


    @Test
    public void chromeTesting() throws MalformedURLException {

        DesiredCapabilities caps= new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "PIXEL");
        caps.setCapability("appPackage","com.android.chrome");
        caps.setCapability("appActivity", "org.chromium.chrome.browser.document.ChromeLauncherActivity");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"), caps);

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.findElementById("com.android.chrome:id/terms_accept").click();
        driver.findElementById("com.android.chrome:id/negative_button").click();
        driver.get("www.amazon.com");
        //Browserdan cimri sayfasina gidilir.
        driver.get("https://www.cimri.com");
        driver.findElementById("com.android.chrome:id/positive_button").click();


    }
}
