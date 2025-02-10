package kz.ticketon.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EventsPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public EventsPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));;
    }

    public EventsPage checkEvents() {
        WebElement checkEvents = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@text=\"События\"]"
        )));
        checkEvents.isDisplayed();
        return this;

    }
}