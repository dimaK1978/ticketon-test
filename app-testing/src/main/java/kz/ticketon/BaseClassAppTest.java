package kz.ticketon;


import io.appium.java_client.android.AndroidDriver;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class BaseClassAppTest {
    static AndroidDriver driver = null;


    @BeforeAll
    public static void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("appium:platformName", "Android");
        capabilities.setCapability("appium:deviceName", "sdk_gphone64_x86_64");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:appPackage", "kz.glatis.ticketon");
        capabilities.setCapability("appium:appActivity", "com.google.android.apps.nexuslauncher");
        capabilities.setCapability("appium:newCommandTimeout", 3600);
        capabilities.setCapability("appium:connectHardwareKeyboard", true);

        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            driver = new AndroidDriver(url, capabilities);

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
        }
    }
}
