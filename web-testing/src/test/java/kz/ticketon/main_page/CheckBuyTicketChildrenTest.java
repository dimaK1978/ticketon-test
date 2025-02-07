package kz.ticketon.main_page;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import kz.ticketon.BaseClassWebTest;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.MainMenuButtonsMainPage;
import kz.ticketon.pages.MainPage;
import kz.ticketon.pages.SessionPage;
import kz.ticketon.pages.children.ChapterChildrenPage;
import kz.ticketon.pages.children.EventChildrenPage;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Feature("Выбор и приобремение билетов")
public class CheckBuyTicketChildrenTest extends BaseClassWebTest {
//
//    static Stream<Object[]> cities() {
//        List<Object[]> list = new ArrayList<>();
//        Arrays.asList(Cities.values()).forEach(
//                city -> list.add(new Object[]{city})
//        );
//        return list.stream();
//    }
//
//    @Story("Проверка выбора и приобретения билетов на доступное мероприятие для детей")
//    @ParameterizedTest()
//    @MethodSource("cities")
//    public void checkBuyTicketChildren(Cities city) {
//        SoftAssertions softAssertions = new SoftAssertions();
//        final MainPage mainPage = new MainPage(city, Languages.RUS);
//        mainPage.openPage();
//        final ChapterChildrenPage theatresPage = (ChapterChildrenPage) mainPage.clickMainMenuButton(MainMenuButtonsMainPage.CHILDREN);
//        final EventChildrenPage theatrePlay = (EventChildrenPage) theatresPage.clickFirstEvent();
//        checkEventPageTitle(theatrePlay, softAssertions);
//        final SessionPage sessionChildrenActivity = theatrePlay.getFirstSessionEvent();
//        checkCreateSessionEventsAddAndDelTickets(sessionChildrenActivity, softAssertions);
//        checkMakingOrdere(sessionChildrenActivity, softAssertions);
//        softAssertions.assertAll();
//    }
}
