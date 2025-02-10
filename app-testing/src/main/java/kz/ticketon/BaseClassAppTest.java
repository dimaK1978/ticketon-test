package kz.ticketon;

import io.appium.java_client.android.AndroidDriver;
import kz.ticketon.pages.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class BaseClassAppTest {
    protected AndroidDriver driver;
    protected MainScreenPhonePage mainScreenPhonePage;
    protected ChooseLanguagePage chooseLanguagePage;
    protected ChooseCityPage chooseCityPage;
    protected MainPage mainPage;
    protected EventsPage eventsPage;

    public void initialize() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "sdk_gphone64_x86_64");
        capabilities.setCapability("platformVersion", "15");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "kz.glatis.ticketon");
        capabilities.setCapability("appActivity", ".MainActivity2");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 🔹 Проверка доступных контекстов (NATIVE_APP, WEBVIEW и т. д.)
        Set<String> contexts = driver.getContextHandles();
        for (String context : contexts) {
            System.out.println("Доступный контекст: " + context);
        }

        // 🔹 Создание экземпляров страниц **после** инициализации драйвера
        mainScreenPhonePage = new MainScreenPhonePage(driver);
        chooseLanguagePage = new ChooseLanguagePage(driver);
        chooseCityPage = new ChooseCityPage(driver);
        mainPage = new MainPage(driver);
        eventsPage = new EventsPage(driver);

    }
}
