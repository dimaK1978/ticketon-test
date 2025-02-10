package kz.ticketon.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MainScreenPhonePage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public MainScreenPhonePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public ChooseLanguagePage clickApp() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.className("android.widget.TextView")));
        element.click();
        return new ChooseLanguagePage(driver);
    }
}
