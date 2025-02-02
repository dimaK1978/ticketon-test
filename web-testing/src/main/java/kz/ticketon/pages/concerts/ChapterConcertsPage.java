package kz.ticketon.pages.concerts;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.SleepUtils;
import kz.ticketon.pages.ChapterPage;
import kz.ticketon.pages.EventPage;
import org.openqa.selenium.By;

public class ChapterConcertsPage extends ChapterPage {
    private final String shortPageUrl = "concerts";
    protected final String pageTitleRus = "Билеты на концерт";
    protected final String pageTitleEng = "Concert tickets";
    protected final String pageTitleKz = "Концертке билеттер";

    public ChapterConcertsPage(Cities city, Languages language) {
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
        return new EventConcertsPage(city, language, titleMovie);
    }
    @Override
    public EventPage clickFirstEvent() {
        SleepUtils.sleepSeconds(5);
        if (eventList.isEmpty()) {
            throw new RuntimeException("Доступных концертов нет");
        }
        return clickEvent(eventList.first());
    }
}
