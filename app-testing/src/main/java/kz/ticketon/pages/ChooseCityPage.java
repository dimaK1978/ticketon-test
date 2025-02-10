package kz.ticketon.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ChooseCityPage {
    private AndroidDriver driver;
    private WebDriverWait wait;

    public ChooseCityPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void selectCity(String city) {
        WebElement clickCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@resource-id='android:id/text1' and @text='Алматы']"
        )));
        clickCity.click();

        WebElement chooseCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.CheckedTextView[@resource-id='android:id/text1' and @text='" + city + "']"
        )));
        chooseCity.click();

        WebElement start = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@text='НАЧАТЬ']"
        )));
        start.click();
    }

    public ChooseCityPage checkCityPage() {
        WebElement textChooseCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.TextView[@text=\"Выберите город\"]"
        )));
        textChooseCity.isDisplayed();
        return this;
    }
}
