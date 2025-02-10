package kz.ticketon;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import kz.ticketon.pages.*;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;

public class BaseClassAppTest {
    protected static AndroidDriver driver;

    @BeforeAll
    public static void initialize() throws MalformedURLException {
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
    }

    @Step("Проверка открытия экрана устаноки города")
    public ChooseCityPage checkChooseCityPage(ChooseCityPage chooseCityPage) {
        final String xpathButtonChooseCity = "//android.widget.TextView[@text='%s']";
        final String titleString = switch (chooseCityPage.getLanguage()) {
            case KZ -> "nn";
            case ENG -> "en";
            default -> "Выберите город";
        };

        WebElement textChooseCity = chooseCityPage.getWait().until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format(xpathButtonChooseCity, titleString))
        ));
        textChooseCity.isDisplayed();
        return chooseCityPage;
    }
}
