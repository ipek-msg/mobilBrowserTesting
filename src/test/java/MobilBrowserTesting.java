import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class MobilBrowserTesting {


    @Test
    public void Mobil () throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "11.0");
        caps.setCapability("deviceName", "PIXEL");
        caps.setCapability("browserName","chrome");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,"60000");
        caps.setCapability("chromedriverExecutable", "C:\\Users\\ipeks\\IdeaProjects\\mobilBrowserTesting\\src\\driver\\chromedriver.exe");

        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(new URL("http://localhost:4723/wd/hub"),caps);

        // Amazon sitesine gidilir
        driver.get("https://www.amazon.com.tr");

       // Set<String> butunsayfalar = driver.getContextHandles();
        //for (String tur : butunsayfalar) {

         //   if (tur.contains("WEBVIEW_chrome")) {
         //       driver.context(tur);
         //   }
       // }

        //System.out.println(driver.getContext() + " Anasayfaya ulasildi");


        MobileElement logo = driver.findElementByXPath("//a[@id='nav-logo-sprites']");
        Assert.assertTrue(logo.isEnabled());
        System.out.println("Ana sayfaya ulasildi");

        MobileElement sigInButton = driver.findElementByXPath("//a[@id='nav-logobar-greeting']");
        sigInButton.click();
        System.out.println("Giris sayfasina ulasildi");

        //Login sayfana ulasildi
        MobileElement sigInTitle = driver.findElementByXPath("//h2");
        Assert.assertTrue(sigInTitle.isDisplayed());

        driver.findElementByXPath("//span[text()='Hesap oluşturun']").isDisplayed();

        driver.findElementByXPath("//a[@id='register_accordion_header']").click();
        System.out.println("Sayfa kapatildi");
        driver.closeApp();



    }
}
