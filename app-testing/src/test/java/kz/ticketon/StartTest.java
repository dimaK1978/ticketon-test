package kz.ticketon;

import kz.ticketon.pages.ChooseCityPage;
import kz.ticketon.pages.ChooseLanguagePage;
import kz.ticketon.pages.MainScreenAppPage;
import kz.ticketon.pages.MainScreenPhonePage;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

public class StartTest extends BaseClassAppTest {

    @Test
    public void startTicketon() throws MalformedURLException {
       final MainScreenPhonePage mainScreenPhonePage = new MainScreenPhonePage(driver);
       final ChooseLanguagePage chooseLanguagePage = mainScreenPhonePage.clickApp();
        checkLanguagePage(chooseLanguagePage);
        final ChooseCityPage chooseCityPage = chooseLanguagePage.selectLanguage(Languages.ENG);
       final MainScreenAppPage mainScreenAppPage = chooseCityPage.selectCity(Cities.ASTANA);
       /*  checkChooseCityPage(chooseCityPage);
             chooseCityPage.checkCityPage()
                .selectCity("Астана");
        mainPage.checkMainPage()
                .clickMenu()
                .clickEvents();
        eventsPage.checkEvents();*/
    }
}
//
//// Неявное ожидание
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//// Проверка доступных контекстов
//Set<String> contexts = driver.getContextHandles();
//        for (String context : contexts) {
//        System.out.println("Доступный контекст: " + context);
//        }

//// Ожидание видимости элемента
////Это должно быть в классе MainScreenPhonePage
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(
//        "android.widget.TextView"
//)));
//// Ожидание кликабельности элемента
//element = wait.until(ExpectedConditions.elementToBeClickable(element));
//        element.click();
////Это должно быть в классе ChooseLanguagePage
//WebElement chooselanguage = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(
//        "android:id/text1"
//)));
//        chooselanguage.click();
//
//WebElement language = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
//        "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Русский\"]"
//)));
//        language.click();
//
//WebElement further = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
//        "//android.widget.TextView[@text=\"ДАЛЕЕ\"]"
//)));
//        further.click();
////это должно быть в классе ChooseCityPage
//WebElement clickCity = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
//        "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Алматы\"]"
//)));
//        clickCity.click();
//
//WebElement chooseCity = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
//        "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\" and @text=\"Астана\"]"
//)));
//        chooseCity.click();
//
//WebElement start = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
//        "//android.widget.TextView[@text=\"НАЧАТЬ\"]"
//)));
//        start.click();
//    }
//            }
