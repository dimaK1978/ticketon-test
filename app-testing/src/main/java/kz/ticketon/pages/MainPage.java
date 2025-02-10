package kz.ticketon.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public MainPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public MainPage checkMainPage() {
        WebElement checkMain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@text=\"Главная\"]"
        )));
        checkMain.isDisplayed();
        return this;
    }

    public MainPage clickMenu() {
        WebElement clickMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup"
        )));
        clickMenu.click();
        return this;
    }

    public EventsPage clickEvents() {
        WebElement clickEvents = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@text=\"События\"]"
        )));
        clickEvents.click();
        return new EventsPage(driver);
    }
}