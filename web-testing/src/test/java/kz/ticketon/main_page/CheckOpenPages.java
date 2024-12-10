package kz.ticketon.main_page;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import kz.ticketon.BaseClassWebTest;
import kz.ticketon.CitiesMain;
import kz.ticketon.LanguagesMain;
import org.junit.jupiter.api.Test;

@Story("Проверка переходов на страницы разделов главного меню")
public class CheckOpenPages extends BaseClassWebTest {

    @Test
    @Description()
    public void checkStartRus(){
        openMainPage(LanguagesMain.RUS, CitiesMain.NO_CITY);
    }

    @Test
    public void checkStartKz(){
        openMainPage(LanguagesMain.ENG, CitiesMain.NO_CITY);
    }

    @Test
    public void checkStartEng(){
        openMainPage(LanguagesMain.KZ, CitiesMain.NO_CITY);
    }
}
