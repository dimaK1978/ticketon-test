package kz.ticketon;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import kz.ticketon.pages.MainPage;
import kz.ticketon.pages.ChapterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.util.Assert;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class BaseClassWebTest extends BaseClassTest {
    protected static String BASIC_URL = "https://ticketon.kz";
    protected static int TIME_OUT = 20000;


    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        //  Configuration.pageLoadStrategy = "normal";
        Configuration.timeout = TIME_OUT;
        Configuration.browserCapabilities =
                new ChromeOptions().addArguments("--remote-allow-origins=*");
    }


    @Step("Переход на страницы через пункаты главного меню с учетом выбора города и языка")
    public void chooseMaimMenu(
            final MainMenuButtonsMainPage MainMenuButton,
            final Languages language,
            final Cities city
    ) {
        final MainPage mainPage = new MainPage(city, language);
        mainPage.openPage();
        final ChapterPage chapterPage = mainPage.clickMainMenuButton(MainMenuButton);

        final String actualTitle = chapterPage.getPageTitle().getText();
        final String expectedTitle = chapterPage.getPageTitleExpected();
        Assert.isTrue(actualTitle.equals(expectedTitle), "Заголовок страницы не совпадает с ожидаемым");
    }

    @Step("Проверка переключения языка главной страницы")
    public void checkChangeLanguageMaim(
            final Languages startPageLanguage,
            final Languages newLanguage,
            final Cities city

    ) {
        MainPage mainPage = new MainPage(city, startPageLanguage);
        mainPage.openPage();
        mainPage.changeLanguage(newLanguage);
        if (newLanguage == Languages.RUS) {
            webdriver().shouldHave(url(mainPage.getPageUrlCityLanguage() + "/"));
        } else {
            webdriver().shouldHave(url(mainPage.getPageUrlCityLanguage()));
        }
        if (newLanguage == Languages.RUS) {
            webdriver().shouldHave(url(mainPage.getPageUrlCityLanguage() + "/"));
        } else {
            webdriver().shouldHave(url(mainPage.getPageUrlCityLanguage()));
        }

        final String actualLanguageText = mainPage.getAccordeonLanguage().getOwnText();
        Assert.isTrue(
                actualLanguageText.equals(newLanguage.getDisplyName()),
                "отображение языка страницы не соответсвует ожиданиям"
        );
    }

    @Step("Проверка переключения города главной страницы")
    public void checkChangeCityMaim(
            final Cities startPageCity,
            final Languages language,
            final Cities newCity

    ) {
        MainPage mainPage = new MainPage(startPageCity, language);
        mainPage.openPage();
        mainPage.changeSity(newCity);

        webdriver().shouldHave(url(mainPage.getPageUrlCityLanguage()));

        final String actualPageTitle = mainPage.getPageTitle().getOwnText().trim();
        final String expectedPageTitle = mainPage.fullPageTitleCityLanguage();

        Assert.isTrue(
                actualPageTitle.equals(expectedPageTitle),
                "отображение города на странице не соответсвует ожиданиям"
        );

        final String actualShowCity = mainPage.getAccordeonCity().getOwnText();
        final String expectedShowCity = mainPage.getCityName();
        Assert.isTrue(
                actualShowCity.equals(expectedShowCity),
                "отображаемый город  не соответсвует ожиданиям"
        );
    }

    @Step("Проветка перехода на страницy события аффиши при клике на его иконку")
    public void chooseEventScheduleMaim(final Cities city) {
        /*   openMainPage(Languages.RUS, city);
        SelenideElement wind1 = $("div[class='FullScreenDetailedCard_content__pxOGG FullScreenDetailedCard_backgroundOverlay__ceXQ5']");//.click();
        final String xz = wind1.find("div[class='FullScreenDetailedCard_eventTitle__PpM1W']").getOwnText();
        wind1.doubleClick();
        String s = $("div[class='_ontentDetails_title__uUkkl']").find("h1").getText();
        Assert.isTrue(xz.contains(s), "Заголовок иконки не совпдает с заголовком страницы события");*/
    }


    @AfterEach
    public void tearDownBrowser() {
        Selenide.closeWebDriver();
    }
}