package kz.ticketon;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import kz.ticketon.pages.ChooseCityPage;
import kz.ticketon.pages.ChooseLanguagePage;
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

    @Step("Проверка открытия экрана выбора языка, заголовок экрана по умолчанию на русском")
    public ChooseLanguagePage checkLanguagePage(ChooseLanguagePage chooseLanguagePage) {
        try {
            WebElement textChooseLanguage = chooseLanguagePage.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(
                    "//android.widget.TextView[@text='Выберите язык']"
            )));
        } catch (Exception e) {
            throw new RuntimeException("Ожидаемый заголовок экрана не найден");
        }
        return chooseLanguagePage;
    }

    @Step("Проверка открытия экрана устаноки города")
    public ChooseCityPage checkChooseCityPage(ChooseCityPage chooseCityPage) {
        final String xpathButtonChooseCity = "//android.widget.TextView[@text='%s']";
        final String titleString = switch (chooseCityPage.getLanguage()) {
            case KZ -> "Қаланы таңдаңыз";
            case ENG -> "Choose city";
            default -> "Выберите город";
        };

        try {
            WebElement textChooseCity = chooseCityPage.getWait().until(ExpectedConditions.elementToBeClickable(
                    By.xpath(String.format(xpathButtonChooseCity, titleString))
            ));
        } catch (Exception e) {
            throw new RuntimeException("Ожидаемый заголовок экрана не найден");
        }
        return chooseCityPage;
    }
}
