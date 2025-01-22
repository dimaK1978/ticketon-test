package kz.ticketon.pages;

import com.codeborne.selenide.SelenideElement;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.pages.cinema.EventCinemaPage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ChapterPageTours extends ChapterPage {
    private final String shortPageUrl = "tours";

    protected final String pageTitleRus = "Туры";
    protected final String pageTitleEng = "Tours";
    protected final String pageTitleKz = "Саяхаттар";

    public ChapterPageTours(Cities city, Languages language) {
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
        if (movieList.isEmpty()) {
            throw new RuntimeException("Доступных фильмов нет");
        }
        return clickEvent(movieList.first());
    }
}
