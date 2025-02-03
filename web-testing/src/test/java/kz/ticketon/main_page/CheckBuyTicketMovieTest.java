//package kz.ticketon.main_page;
//
//import io.qameta.allure.Feature;
//import io.qameta.allure.Story;
//import kz.ticketon.BaseClassWebTest;
//import kz.ticketon.Cities;
//import kz.ticketon.Languages;
//import kz.ticketon.MainMenuButtonsMainPage;
//import kz.ticketon.pages.MainPage;
//import kz.ticketon.pages.SessionPage;
//import kz.ticketon.pages.cinema.ChapterCinemaPage;
//import kz.ticketon.pages.cinema.EventCinemaPage;
//import org.assertj.core.api.SoftAssertions;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.MethodSource;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Stream;
//
//@Feature("Выбор и приобремение билетов")
//public class CheckBuyTicketMovieTest extends BaseClassWebTest {
//
//    static Stream<Object[]> cities() {
//        List<Object[]> list = new ArrayList<>();
//        Arrays.asList(Cities.values()).forEach(
//                city -> list.add(new Object[]{city})
//        );
//        return list.stream();
//    }
//
//    @Story(("Проверка выбора и приобретения билетов в кино на доступный фильм"))
//    @ParameterizedTest()
//    @MethodSource(value = "cities()")
//    public void checkBuyTicketMovie(Cities city) {
//        SoftAssertions softAssertions = new SoftAssertions();
//        final MainPage mainPage = new MainPage(city, Languages.RUS);
//        mainPage.openPage();
//        final ChapterCinemaPage pageCinema = (ChapterCinemaPage) mainPage.clickMainMenuButton(MainMenuButtonsMainPage.CINEMA);
//        final EventCinemaPage movie = (EventCinemaPage) pageCinema.clickFirstEvent();
//        checkEventPageTitle(movie, softAssertions);
//        final SessionPage sessionMovie = movie.getFirstSessionEvent();
//        checkCreateSessionEventsAddAndDelTickets(sessionMovie, softAssertions);
//        checkMakingOrdere(sessionMovie, softAssertions);
//        softAssertions.assertAll();
//    }
//}
