package kz.ticketon.pages.cinema;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.SleepUtils;
import kz.ticketon.pages.ChapterPage;
import kz.ticketon.pages.EventPage;
import org.openqa.selenium.By;

public class ChapterCinemaPage extends ChapterPage {

    private final String shortPageUrl = "cinema";
    private final String pageTitleRus = "Билеты в кино";
    private final String pageTitleEng = "Movie tickets";
    private final String pageTitleKz = "Киноға билеттер";

    public ChapterCinemaPage(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
    @Override
    @Step("Клик на доступное событие")
    public EventPage clickEvent(final SelenideElement movie) {
        final String titleMovie = movie.scrollTo().$(new By.ByTagName("a")).getAttribute("title");
        movie.scrollTo().click();
        return new EventCinemaPage(city, language, titleMovie);
    }
    @Override
    public EventPage clickFirstEvent() {
        SleepUtils.sleepSeconds(5);
        if (eventList.isEmpty()) {
            throw new RuntimeException("Доступных фильмов нет");
        }
        return clickEvent(eventList.first());
    }
}
