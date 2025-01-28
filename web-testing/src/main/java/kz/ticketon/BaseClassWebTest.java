package kz.ticketon;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;

import dev.failsafe.internal.util.Assert;
import io.qameta.allure.Step;
import kz.ticketon.pages.*;
import kz.ticketon.pages.cinema.ChapterCinemaPage;
import kz.ticketon.pages.cinema.EventCinemaPage;
import kz.ticketon.pages.SessionPage;
import kz.ticketon.pages.concerts.ChapterConcertsPage;
import kz.ticketon.pages.concerts.EventConcertsPage;
import kz.ticketon.pages.sports.ChapterSportsPage;
import kz.ticketon.pages.sports.EventSportsPage;
import kz.ticketon.pages.theatres.ChapterTheatresPage;
import kz.ticketon.pages.theatres.EventTheatresPage;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;


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

    @Step("Проверка перехода к форме покупки билетов в кино на доступный фильм")
    public void checkBuyTicketMovie(
            final Cities city,
            final Languages language
    ) {
        SoftAssertions softAssertions = new SoftAssertions();
        final MainPage mainPage = new MainPage(city, language);
        mainPage.openPage();
        final ChapterCinemaPage pageCinema = (ChapterCinemaPage) mainPage.clickMainMenuButton(MainMenuButtonsMainPage.CINEMA);
        final EventCinemaPage movie = (EventCinemaPage) pageCinema.clickFirstEvent();
        final String titleExpectMovie = movie.getTitleExpect();
        final String titleActualMovie = movie.getTitleActual();
        softAssertions.assertThat(titleActualMovie).isEqualTo(titleExpectMovie);
        final SessionPage sessionMovie = movie.getFirstSessionEvent();
        sessionMovie.clickSeatAddTicket();
        checkCreateSessionEventsAddAndDelTickets(sessionMovie, softAssertions);
        softAssertions.assertAll();
    }

    @Step("Проверка перехода к форме покупки билета в театр на доступный спектакль")
    public void checkBuyTicketTheatrePlay(
            final Cities city,
            final Languages language
    ) {
        SoftAssertions softAssertions = new SoftAssertions();
        final MainPage mainPage = new MainPage(city, language);
        mainPage.openPage();
        final ChapterTheatresPage theatresPage = (ChapterTheatresPage) mainPage.clickMainMenuButton(MainMenuButtonsMainPage.THEATRES);
        final EventTheatresPage theatrePlay = (EventTheatresPage) theatresPage.clickFirstEvent();
        final String titleExpectTheatrePlay = theatrePlay.getTitleExpect();
        final String titleActualTheatrePlay = theatrePlay.getTitleActual();
        softAssertions.assertThat(titleActualTheatrePlay).isEqualTo(titleExpectTheatrePlay);
        final SessionPage sessionTheatrePlay = theatrePlay.getFirstSessionEvent();
        sessionTheatrePlay.clickSeatAddTicket();
        checkCreateSessionEventsAddAndDelTickets(sessionTheatrePlay, softAssertions);
        softAssertions.assertAll();
    }

    @Step("Проверка перехода к форме покупки билета на концерт на доступный спектакль")
    public void checkBuyTicketConcerts(
            final Cities city,
            final Languages language
    ) {
        SoftAssertions softAssertions = new SoftAssertions();
        final MainPage mainPage = new MainPage(city, language);
        mainPage.openPage();
        final ChapterConcertsPage concertsPage = (ChapterConcertsPage) mainPage.clickMainMenuButton(MainMenuButtonsMainPage.CONCERTS);
        final EventConcertsPage concert = (EventConcertsPage) concertsPage.clickFirstEvent();
        final String titleExpectConcert = concert.getTitleExpect();
        final String titleActualConcert = concert.getTitleActual();
        softAssertions.assertThat(titleActualConcert).isEqualTo(titleExpectConcert);
        final SessionPage sessionConcert = concert.getFirstSessionEvent();
        sessionConcert.clickSeatAddTicket();
        checkCreateSessionEventsAddAndDelTickets(sessionConcert, softAssertions);
        softAssertions.assertAll();
    }

    @Step("Проверка перехода к форме покупки билета на концерт на доступный спектакль")
    public void checkBuyTicketSports(
            final Cities city,
            final Languages language
    ) {
        SoftAssertions softAssertions = new SoftAssertions();
        final MainPage mainPage = new MainPage(city, language);
        mainPage.openPage();
        final ChapterSportsPage sportsPage = (ChapterSportsPage) mainPage.clickMainMenuButton(MainMenuButtonsMainPage.SPORT);
        final EventSportsPage sportGame = (EventSportsPage) sportsPage.clickFirstEvent();
        final String titleExpectSportGame = sportGame.getTitleExpect();
        final String titleActualSportGame = sportGame.getTitleActual();
        softAssertions.assertThat(titleActualSportGame).isEqualTo(titleExpectSportGame);
        final SessionPage sessionSportGame = sportGame.getFirstSessionEvent();
        sessionSportGame.clickSeatAddTicket();
        checkCreateSessionEventsAddAndDelTickets(sessionSportGame, softAssertions);
        softAssertions.assertAll();
    }

    @Step("Проверка перехода к форме покупки билета в музей")
    public void checkBuyTicketMuseums(
            final Cities city,
            final Languages language
    ) {
        SoftAssertions softAssertions = new SoftAssertions();
        final MainPage mainPage = new MainPage(city, language);
        mainPage.openPage();
        final ChapterSportsPage sportsPage = (ChapterSportsPage) mainPage.clickMainMenuButton(MainMenuButtonsMainPage.MUSEUMS);
        final EventSportsPage sportGame = (EventSportsPage) sportsPage.clickFirstEvent();
        final String titleExpectSportGame = sportGame.getTitleExpect();
        final String titleActualSportGame = sportGame.getTitleActual();
        softAssertions.assertThat(titleActualSportGame).isEqualTo(titleExpectSportGame);
        final SessionPage sessionSportGame = sportGame.getFirstSessionEvent();
        sessionSportGame.clickSeatAddTicket();
        checkCreateSessionEventsAddAndDelTickets(sessionSportGame, softAssertions);
        softAssertions.assertAll();
    }
    @Step("Проверка поиска событий")
    public void checkSearchEvents(
            final Cities city,
            final Languages language
    ) {
        MainPage mainPage = new MainPage(city, language);
        mainPage.openPage();
        String eventString = mainPage.getEventTitle();

        SearchResultPage searchResultPage = mainPage.searchEvent(eventString);

        Assert.isTrue(
                searchResultPage.eventIsExists(eventString),
                "На странице отсутсвует событие с искомым заголовком"
        );
    }

    @Step("Проверка правильности заполнения формы события при приобретении билета, выбора, добавления и удаления билетов")
    protected void checkCreateSessionEventsAddAndDelTickets(final SessionPage sessionPage, final SoftAssertions softAssertions) {
        final String titleExpectSession = sessionPage.getTitleExpect();
        final String titleActualSession = sessionPage.getTitleActual();
        softAssertions.assertThat(titleExpectSession).contains( titleActualSession);
        final String fullDataSessionExpect = sessionPage.getFullDataSessionExpect();
        final String fullDataSessionActual = sessionPage.getFullDataSessionActual();
        softAssertions.assertThat(fullDataSessionActual).contains(fullDataSessionExpect);
        softAssertions.assertThat(sessionPage.getTicketQantiti()).isEqualTo(1);
        sessionPage.clickSeatAddTicket();
        softAssertions.assertThat(sessionPage.getTicketQantiti()).isEqualTo(2);
        sessionPage.deleteTicket();
        softAssertions.assertThat(sessionPage.getTicketQantiti()).isEqualTo(1);
    }

    @AfterEach
    public void tearDownBrowser() {
        Selenide.closeWebDriver();
    }
}