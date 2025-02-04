package kz.ticketon.main_page;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import kz.ticketon.BaseClassWebTest;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.MainMenuButtonsMainPage;
import kz.ticketon.pages.MainPage;
import kz.ticketon.pages.SessionPage;
import kz.ticketon.pages.theatres.ChapterTheatresPage;
import kz.ticketon.pages.theatres.EventTheatresPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Feature("Выбор и приобремение билетов")
public class CheckBuyTicketTheatreTest extends BaseClassWebTest {

    static Stream<Object[]> cities() {
        List<Object[]> list = new ArrayList<>();
        Arrays.asList(Cities.values()).forEach(
                city -> list.add(new Object[]{city})
        );
        return list.stream();
    }

    @Story("Проверка перехода к форме покупки билета в театр на доступный спектакль")
    @ParameterizedTest()
    @MethodSource("cities")
    public void checkBuyTicketTheatre(Cities city) {
        SoftAssertions softAssertions = new SoftAssertions();
        final MainPage mainPage = new MainPage(city, Languages.RUS);
        mainPage.openPage();
        final ChapterTheatresPage theatresPage = (ChapterTheatresPage) mainPage.clickMainMenuButton(MainMenuButtonsMainPage.THEATRES);
        final EventTheatresPage theatrePlay = (EventTheatresPage) theatresPage.clickFirstEvent();
        checkEventPageTitle(theatrePlay, softAssertions);
        final SessionPage sessionTheatrePlay = theatrePlay.getFirstSessionEvent();
        checkCreateSessionEventsAddAndDelTickets(sessionTheatrePlay, softAssertions);
        checkMakingOrdere(sessionTheatrePlay, softAssertions);
        softAssertions.assertAll();
    }
}
