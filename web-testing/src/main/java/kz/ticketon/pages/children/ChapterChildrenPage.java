package kz.ticketon.pages.children;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.SleepUtils;
import kz.ticketon.pages.ChapterPage;
import kz.ticketon.pages.EventPage;
import kz.ticketon.pages.cinema.EventCinemaPage;
import org.openqa.selenium.By;

public class ChapterChildrenPage extends ChapterPage {

    private final String shortPageUrl = "children";
    protected final String pageTitleRus = "Билеты детям";
    protected final String pageTitleEng = "Children tickets";
    protected final String pageTitleKz = "Балаларға билеттер";

    public ChapterChildrenPage(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
    @Override
    @Step("Клик на доступное событие")
    public EventPage clickEvent(final SelenideElement event) {
        final String titleMovie = event.$(new By.ByTagName("a")).getAttribute("title");
        event.scrollTo().click();
        return new EventChildrenPage(city, language, titleMovie);
    }
    @Override
    public EventPage clickFirstEvent() {
        SleepUtils.sleepSeconds(5);
        if (eventList.isEmpty()) {
            throw new RuntimeException("Доступных мероприятий нет");
        }
        return clickEvent(eventList.first());
    }
}
