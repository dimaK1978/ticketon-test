package kz.ticketon.pages.sports;

import com.codeborne.selenide.SelenideElement;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.pages.ChapterPage;
import kz.ticketon.pages.EventPage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ChapterSportsPage extends ChapterPage {
    private final String shortPageUrl = "sports";

    protected final String pageTitleRus = "Билеты на спорт";
    protected final String pageTitleEng = "Sports tickets";
    protected final String pageTitleKz = "Спорт билеттері";

    public ChapterSportsPage(Cities city, Languages language) {
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
        return new EventSportsPage(city, language, titleMovie);
    }
    @Override
    public EventPage clickFirstEvent() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (movieList.isEmpty()) {
            throw new RuntimeException("Доступных спортивных мероприятий нет");
        }
        return clickEvent(movieList.first());
    }
}
