package kz.ticketon;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import kz.ticketon.pages.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.webdriver;

public class BaseClassWebTest extends BaseClassTest {
    protected static int TIME_OUT = 100000;

    @BeforeAll
    public static void setUpAll() {
        Configuration.browserSize = "1280x800";
        Configuration.timeout = TIME_OUT;
        Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Step("Проверка заполнения формы события, выбора, добавление 2 билетов, удаления 1 билета, провека результата")
    public void checkCreateSessionEventsAddAndDelTickets(final SessionPage sessionPage, final SoftAssertions softAssertions) {
        final String titleExpectSession = sessionPage.getTitleExpect();
        final String titleActualSession = sessionPage.getTitleActual();
        softAssertions.assertThat(titleExpectSession).contains(titleActualSession);
        final String fullDataSessionExpect = sessionPage.getFullDataSessionExpect();
        final String fullDataSessionActual = sessionPage.getFullDataSessionActual();
        softAssertions.assertThat(fullDataSessionActual).contains(fullDataSessionExpect);
        softAssertions.assertThat(sessionPage.getTicketQantiti()).isEqualTo(1);
        sessionPage.clickSeatAddTicket();
        softAssertions.assertThat(sessionPage.getTicketQantiti()).isEqualTo(2);
        sessionPage.deleteTicket();
        softAssertions.assertThat(sessionPage.getTicketQantiti()).isEqualTo(1);
    }

    @Step("Проверка заголовка страницы события, его соотвеьсвие выбранному")
    public void checkEventPageTitle(final EventPage eventPage, final SoftAssertions softAssertions) {
        final String titleExpectEventPage = eventPage.getTitleExpect();
        final String titleActualEventPage = eventPage.getTitleActual();
        softAssertions.assertThat(titleActualEventPage).isEqualTo(titleExpectEventPage);
    }

    @Step("Проверка перехода к оформлению заказа")
    public void checkMakingOrdere(final SessionPage sessionPage, final SoftAssertions softAssertions) {
        MakingOrderPage makingOrderPage = sessionPage.makingOrder();
        final String titleExpect = makingOrderPage.getTitleExpected();
        final String titleActual = makingOrderPage.getTitleActual();
        softAssertions.assertThat(titleActual).contains(titleExpect);
    }

    @Step("Проверка нахождения страницы по заголовку в результатах поиска")
    public void checkSearchEventsByTitle(
            final MainPage mainPage,
            final String eventTitle,
            final SoftAssertions softAssertions
    ) {
        SearchResultPage searchResultPage = mainPage.searchEvent(eventTitle);
        softAssertions.assertThat(searchResultPage.eventIsExists(eventTitle)).isTrue();
    }

    @Step("Проверка соответсвия заголовка открывшейся страницы выбранного раздела ожиданиям")
    public void checkChapterTitle(
            final ChapterPage chapterPage,
            final SoftAssertions softAssertions
    ) {
        softAssertions
                .assertThat(chapterPage.getPageTitle())
                .isEqualTo(chapterPage.getPageTitleExpected());

    }

    @Step("Проверка URL главной страницы для выбранного города и языка")
    public void checkUrlPageCityLanguageMaim(
            final MainPage mainPage,
            final SoftAssertions softAssertions
    ) {
        SleepUtils.sleepSeconds(5);
        softAssertions
                .assertThat(webdriver().driver().url())
                .contains(mainPage.getPageUrlCityLanguage());
    }

    public void checkViewLanguageMaim(
            final MainPage mainPage,
            final Languages language,
            final SoftAssertions softAssertions
    ) {
        softAssertions
                .assertThat(mainPage.getActualShowCity())
                .isEqualTo(language.getDisplyName());

    }

    @Step("Проверка имени города отображаемого на странице")
    public void checkViewCityMaim(
            final MainPage mainPage,
            final Cities city,
            final SoftAssertions softAssertions
    ) {
        softAssertions
                .assertThat(mainPage.getActualShowCity())
                .isEqualTo(mainPage.getCityName(city));
    }

    @Step("Проверка отображения имени города в заголовке страницы")
    public void checkViewCityTitleMaim(
            final MainPage mainPage,
            final Cities city,
            final SoftAssertions softAssertions
    ) {
        softAssertions
                .assertThat(mainPage.getHeaderEventSchedule())
                .contains(mainPage.getCityName(city));
    }

    @AfterEach
    public void tearDownBrowser() {
        Selenide.closeWebDriver();
    }
}