package kz.ticketon.pages;

import io.appium.java_client.android.AndroidDriver;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainScreenAppPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;
    protected Cities city;
    protected Languages language;

    public MainScreenAppPage(final AndroidDriver driver, final Languages language, final Cities city) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.city = city;
        this.language = language;
    }

    public MainScreenAppPage checkMainPage() {
        WebElement checkMain = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@text=\"Главная\"]"
        )));
        checkMain.isDisplayed();
        return this;
    }

    public MainScreenAppPage clickMenu() {
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