package kz.ticketon.pages.christmas_event;

import com.codeborne.selenide.SelenideElement;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.pages.ChapterPage;
import kz.ticketon.pages.EventPage;
import kz.ticketon.pages.cinema.EventCinemaPage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ChapterChristmasEventPage extends ChapterPage {
    private final String shortPageUrl = "christmas-event";
    protected final String pageTitleRus = "Новогодние события";
    protected final String pageTitleEng = "Christmas Event";
    protected final String pageTitleKz = "ЖАНА-ЖЫЛ";

    public ChapterChristmasEventPage(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
    @Override
    public EventPage clickEvent(final SelenideElement movie) {
        final String titleMovie = movie.$(new By.ByTagName("a")).getAttribute("title");
        movie.scrollTo().click();
        return new EventCinemaPage(city, language, titleMovie);
    }
    @Override
    public EventPage clickFirstEvent() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (eventList.isEmpty()) {
            throw new RuntimeException("Доступных новогодних мероприятий нет");
        }
        return clickEvent(eventList.first());
    }
}
