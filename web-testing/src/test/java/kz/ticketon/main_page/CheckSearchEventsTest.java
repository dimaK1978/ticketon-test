package kz.ticketon.main_page;

import kz.ticketon.BaseClassWebTest;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.MainMenuButtonsMainPage;
import org.junit.jupiter.api.Test;

public class CheckSearchEventsTest extends BaseClassWebTest {
    @Test
    public void CheckSearchEvents() {
        checkSearchEvents(Cities.NO_CITY, Languages.RUS);
    }
}
