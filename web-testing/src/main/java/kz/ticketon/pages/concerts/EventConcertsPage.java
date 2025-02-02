package kz.ticketon.pages.concerts;

import com.codeborne.selenide.SelenideElement;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.pages.EventPage;
import kz.ticketon.pages.SessionPage;
import kz.ticketon.pages.museums.SessionMuseumNewFormPage;

import static com.codeborne.selenide.Selenide.*;

public class EventConcertsPage extends EventPage {

    private final SelenideElement frameFormChoosePlase = $("[id='widgetFrame']");

    public EventConcertsPage(final Cities city, final Languages language, final String title) {
        super(city, language, title);
        availableSessions = $$x("//div[@class='EventScheduleRow_eventScheduleRow__gQsT9']");
        stringForFindLocation = "div[class='Place_placeWrapper__XP_Ng']";
    }

    @Override
    protected SessionPage createSesionPage(
            final String time,
            final String day,
            final String month,
            final String eventLocation
    ) {
        if (frameFormChoosePlase.exists()) {
            switchTo().frame(frameFormChoosePlase);
            return new SessionConsertOldFormPage(title, time, day, month, eventLocation);
        } else {
            throw new RuntimeException("Форма для выбора билетов не загрузилась");
        }
    }

}
