package kz.ticketon.pages.master_classes;

import com.codeborne.selenide.SelenideElement;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.pages.ChapterPage;
import kz.ticketon.pages.EventPage;
import kz.ticketon.pages.concerts.EventConcertsPage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class ChapterMasterClassesPage extends ChapterPage {
    private final String shortPageUrl = "master-classes";

    protected final String pageTitleRus = "Мастер-классы";
    protected final String pageTitleEng = "Master classes";
    protected final String pageTitleKz = "Мастер-класстар";


    public ChapterMasterClassesPage(Cities city, Languages language) {
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
        return new EventConcertsPage(city, language, titleMovie);
    }
    @Override
    public EventPage clickFirstEvent() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (movieList.isEmpty()) {
            throw new RuntimeException("Доступных концертов нет");
        }
        return clickEvent(movieList.first());
    }
}
