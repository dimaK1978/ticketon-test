package kz.ticketon.pages.tours;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.SleepUtils;
import kz.ticketon.pages.ChapterPage;
import kz.ticketon.pages.EventPage;
import kz.ticketon.pages.cinema.EventCinemaPage;
import org.openqa.selenium.By;

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
    @Step("Клик на доступное событие")
    public EventPage clickEvent(final SelenideElement movie) {
        final String titleMovie = movie.$(new By.ByTagName("a")).getAttribute("title");
        movie.scrollTo().click();
        return new EventCinemaPage(city, language, titleMovie);
    }
    //заглушка, для данного раздела пока полной реализации нет
    @Override
    public EventPage clickFirstEvent() {
        SleepUtils.sleepSeconds(5);
        if (eventList.isEmpty()) {
            throw new RuntimeException("Доступных мероприятий нет");
        }
        return clickEvent(eventList.first());
    }
}
