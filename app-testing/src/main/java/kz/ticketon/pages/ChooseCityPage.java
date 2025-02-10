package kz.ticketon.pages;

import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChooseCityPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private Languages language;
    private String xpahtAccordeonCity = "//android.widget.TextView[@resource-id='android:id/text1' and @text='%s']";
    private String xpahtChooseCity = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='%s']";
    private String xpathButtonNext = "//android.widget.TextView[@text='%s']";

    public ChooseCityPage(AndroidDriver driver, Languages language) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.language = language;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public Languages getLanguage() {
        return language;
    }

    @Step("Выбор города при открытии")
    public MainScreenAppPage selectCity(Cities city) {
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format(xpahtAccordeonCity, "Алматы"))
        )).click();

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format(xpahtChooseCity, city))
        )).click();

        final String nameButtonString = switch (language) {
            case KZ -> "nn";
            case ENG -> "en";
            default -> "ДАЛЕЕ";
        };

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                String.format(xpathButtonNext, nameButtonString))
        )).click();

        return new MainScreenAppPage(driver, language, city);
    }
}
