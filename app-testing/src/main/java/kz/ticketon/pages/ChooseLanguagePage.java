package kz.ticketon.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ChooseLanguagePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public ChooseLanguagePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void selectLanguage(String language) {
        WebElement chooselanguage = wait.until(ExpectedConditions.elementToBeClickable(By.id("android:id/text1")));
        chooselanguage.click();

        WebElement languageElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Русский\"]"
        )));
        languageElement.click();

        WebElement further = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@text='ДАЛЕЕ']"
        )));
        further.click();
    }

    public ChooseLanguagePage checkLanguagePage() {
        WebElement textChooseLanguage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@text=\"Выберите язык\"]"
        )));
        textChooseLanguage.isDisplayed();
        return this;
    }
}
