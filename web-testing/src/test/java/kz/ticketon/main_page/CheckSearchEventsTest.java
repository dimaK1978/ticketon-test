package kz.ticketon.main_page;

import io.qameta.allure.Story;
import kz.ticketon.BaseClassWebTest;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import org.junit.jupiter.api.Test;

@Story("Проверка элемента поиска событий")
public class CheckSearchEventsTest extends BaseClassWebTest {
    @Test()
    public void CheckSearchEvents() {
        checkSearchEvents(Cities.NO_CITY, Languages.RUS);
    }
}
