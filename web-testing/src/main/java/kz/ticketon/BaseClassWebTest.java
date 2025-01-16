package kz.ticketon;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import kz.ticketon.pages.*;
import kz.ticketon.pages.cinema.ChapterPageCinema;
import kz.ticketon.pages.cinema.EventPageCinema;
import kz.ticketon.pages.cinema.SessionMovieNewFormPage;
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

        final String actualPageTitle = mainPage.getHeaderEventSchedule().getOwnText().trim();
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

    @Step("Проверка перехода к форме покупки билета на первый доступный фильм")
    public void checkBuyTicketMovie(
            final Cities city,
            final Languages language
    ) {
        SoftAssertions softAssertions = new SoftAssertions();
        final MainPage mainPage = new MainPage(city, language);
        mainPage.openPage();
        final ChapterPageCinema pageCinema = (ChapterPageCinema) mainPage.clickMainMenuButton(MainMenuButtonsMainPage.CINEMA);
        final EventPageCinema movie = pageCinema.clickFirstMovie();
        final SessionMoviePage sessionMovie = movie.getFirstSessionMovie();
        sessionMovie.clickSeat();
        final String dateExpect = sessionMovie.getDateExpect();
        final String dateActual = sessionMovie.getDateActual();
        softAssertions.assertThat(dateActual).isEqualTo(dateExpect);

        final String titleExpect = sessionMovie.getTitleExpect();
        final String titleActual = sessionMovie.getTitleActual();
        softAssertions.assertThat(titleActual).isEqualTo(titleExpect);

        final String movieTheatreExpect = sessionMovie.getMovieTheatreExpect();
        final String movieTheatreActual = sessionMovie.getMovieTheatreActual();
        softAssertions.assertThat(movieTheatreActual).isEqualTo(movieTheatreExpect);
        softAssertions.assertAll();
    }

    @AfterEach
    public void tearDownBrowser() {
        Selenide.closeWebDriver();
    }
}