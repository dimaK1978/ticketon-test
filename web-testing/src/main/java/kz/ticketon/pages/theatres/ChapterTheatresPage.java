package kz.ticketon.pages.theatres;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.SleepUtils;
import kz.ticketon.pages.ChapterPage;
import kz.ticketon.pages.EventPage;
import org.openqa.selenium.By;

public class ChapterTheatresPage extends ChapterPage {
    private final String shortPageUrl = "theatres";
    protected final String pageTitleRus = "Билеты в театр";
    protected final String pageTitleEng = "Theater tickets";
    protected final String pageTitleKz = "Театрға билеттер";

    public ChapterTheatresPage(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
    @Override
    @Step("Клик на доступное событие")
    public EventPage clickEvent(final SelenideElement movie) {
        final String titleMovie = movie.$(new By.ByTagName("a")).getAttribute("title");
        movie.scrollTo().click();
        return new EventTheatresPage(city, language, titleMovie);
    }
    @Override
    public EventPage clickFirstEvent() {
        SleepUtils.sleepSeconds(5);
        if (eventList.isEmpty()) {
            throw new RuntimeException("Доступных спектаклей нет");
        }
        return clickEvent(eventList.first());
    }
}
