package kz.ticketon.main_page;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import kz.ticketon.BaseClassWebTest;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.MainMenuButtonsMainPage;
import kz.ticketon.pages.MainPage;
import kz.ticketon.pages.SessionPage;
import kz.ticketon.pages.museums.ChapterMuseumsPage;
import kz.ticketon.pages.museums.EventMuseumPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Feature("Выбор и приобремение билетов")
public class CheckBuyTicketMuseumsTest extends BaseClassWebTest {

    static Stream<Object[]> cities() {
        List<Object[]> list = new ArrayList<>();
        Arrays.asList(Cities.values()).forEach(
                city -> list.add(new Object[]{city})
        );
        return list.stream();
    }

    @Story("Проверка перехода к форме покупки билета в музей")
    @ParameterizedTest()
    @MethodSource(value = "cities()")
    public void checkBuyTicketMuseums(Cities city) {
        SoftAssertions softAssertions = new SoftAssertions();
        final MainPage mainPage = new MainPage(city, Languages.RUS);
        mainPage.openPage();
        final ChapterMuseumsPage museumPagePage = (ChapterMuseumsPage) mainPage.clickMainMenuButton(MainMenuButtonsMainPage.MUSEUMS);
        final EventMuseumPage museumTour = (EventMuseumPage) museumPagePage.clickFirstEvent();
        checkEventPageTitle(museumTour, softAssertions);
        final SessionPage sessionMuseumTour = museumTour.getFirstSessionEvent();
        checkCreateSessionEventsAddAndDelTickets(sessionMuseumTour, softAssertions);
        checkMakingOrdere(sessionMuseumTour, softAssertions);
        softAssertions.assertAll();
    }
}


