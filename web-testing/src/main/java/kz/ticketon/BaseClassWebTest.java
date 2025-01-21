package kz.ticketon;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import kz.ticketon.pages.*;
import kz.ticketon.pages.cinema.ChapterCinemaPage;
import kz.ticketon.pages.cinema.EventPageCinema;
import kz.ticketon.pages.cinema.SessionMoviePage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.util.Assert;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class BaseClassWebTest extends BaseClassTest {
    protected static int TIME_OUT = 100000;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = TIME_OUT;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
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
        final String actualLanguageText = mainPage.getActualLanguageText();
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

        final String actualPageTitle = mainPage.getHeaderEventSchedule().getOwnText().trim();
        final String expectedPageTitle = mainPage.fullPageTitleCityLanguage();

        Assert.isTrue(
                actualPageTitle.equals(expectedPageTitle),
                "отображение города на странице не соответсвует ожиданиям"
        );

        final String actualShowCity = mainPage.getActualShowCity();
        final String expectedShowCity = mainPage.getCityName();
        Assert.isTrue(
                actualShowCity.equals(expectedShowCity),
                "отображаемый город  не соответсвует ожиданиям"
        );
    }

    @Step("Проверка перехода к форме покупки билета на первый доступный фильм")
    public void checkBuyTicketMovie(
            final Cities city,
            final Languages language
    ) {
        SoftAssertions softAssertions = new SoftAssertions();
        final MainPage mainPage = new MainPage(city, language);
        mainPage.openPage();
        final ChapterCinemaPage pageCinema = (ChapterCinemaPage) mainPage.clickMainMenuButton(MainMenuButtonsMainPage.CINEMA);
        final EventPageCinema movie = pageCinema.clickFirstMovie();
        final String titleExpectMovie = movie.getTitleExpect();
        final String titleActualMovie = movie.getTitleActual();
        softAssertions.assertThat(titleActualMovie).isEqualTo(titleExpectMovie);
        final SessionMoviePage sessionMovie = movie.getFirstSessionMovie();
        sessionMovie.clickSeatAddTicket();

        final String titleExpectSession = sessionMovie.getTitleExpect();
        final String titleActualSession = sessionMovie.getTitleActual();
        softAssertions.assertThat(titleActualSession).isEqualTo(titleExpectSession);
        final String fullDataSessionExpect = sessionMovie.getFullDataSessionExpect();
        final String fullDataSessionActual = sessionMovie.getFullDataSessionActual();
        softAssertions.assertThat(fullDataSessionActual).contains(fullDataSessionExpect);

        softAssertions.assertThat(sessionMovie.getTicketQantiti()).isEqualTo(1);

        sessionMovie.clickSeatAddTicket();
        softAssertions.assertThat(sessionMovie.getTicketQantiti()).isEqualTo(2);

        sessionMovie.deleteTicket();
        softAssertions.assertThat(sessionMovie.getTicketQantiti()).isEqualTo(1);
        softAssertions.assertAll();
    }

    @Step("Проверка поиска событий")
    public void checkSearchEvents(
            final Cities city,
            final Languages language
    ) {
        MainPage mainPage = new MainPage(city, language);
        mainPage.openPage();
        String s = mainPage.getEventTitle();
        SearchResultPage searchResultPage = mainPage.searchEvent(s);

        Assert.isTrue(
                searchResultPage.eventIsExists(s),
                "На странице должно присутствовать событие с заданным заголовком"
        );
    }

    @AfterEach
    public void tearDownBrowser() {
        Selenide.closeWebDriver();
    }
}