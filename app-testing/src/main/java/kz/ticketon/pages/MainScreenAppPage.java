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

public class MainScreenAppPage {
    private final AndroidDriver driver;
    private final WebDriverWait wait;
    private Cities city;
    private Languages language;
    private String xpathChapterMenu = "//android.widget.TextView[@text='%s']";

    public MainScreenAppPage(final AndroidDriver driver, final Languages language, final Cities city) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        this.city = city;
        this.language = language;
    }

    public WebDriverWait getWait() {
        return wait;
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

    @Step("Выбор пункта меню 'События'")
    public EventsPage clickEventsEvents() {

        final String eventString = switch (language) {
            case KZ -> "БАСТАУ";
            case ENG -> "START";
            default -> "События";
        };
        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(String.format(xpathChapterMenu, eventString))
        )).click();
        return new EventsPage(driver);
    }
}