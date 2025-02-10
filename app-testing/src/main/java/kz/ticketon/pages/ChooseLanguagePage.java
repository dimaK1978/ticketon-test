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

public class ChooseLanguagePage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private String xpathChooseLanguage = "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='%s']";
    private String xpathButtonNext = "//android.widget.TextView[@text='%s']";

    public ChooseLanguagePage(final AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    @Step("Выбор языка при открытии")
    public ChooseCityPage selectLanguage(final Languages language) {
        WebElement chooselanguage = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/text1")));
        chooselanguage.click();
        final String languageString = switch (language) {
            case KZ -> "nn";
            case ENG -> "en";
            default -> "Русский";
        };
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                String.format(xpathChooseLanguage, languageString))
        )).click();

        final String nameButtonString = switch (language) {
            case KZ -> "nn";
            case ENG -> "en";
            default -> "ДАЛЕЕ";
        };

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                String.format(xpathButtonNext, nameButtonString))
        )).click();
        return new ChooseCityPage(driver, language);
    }


    public void checkLanguagePage() {
        WebElement textChooseLanguage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@text='Выберите язык']"
        )));
        textChooseLanguage.isDisplayed();
    }
}
