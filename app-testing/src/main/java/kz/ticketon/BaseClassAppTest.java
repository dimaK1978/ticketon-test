package kz.ticketon;

import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseClassAppTest extends BaseClassTest {
    
    public void setUp() throws Exception
    {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "sdk_gphone64_x86_64");
        capabilities.setCapability("platformVersion", "15");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "kz.glatis.ticketon");
        capabilities.setCapability("appActivity", ".ui.login.LoginActivity");
        capabilities.setCapability("app", "/Users/s.yakovlev/Desktop/androidAutomation/apks/login.apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
