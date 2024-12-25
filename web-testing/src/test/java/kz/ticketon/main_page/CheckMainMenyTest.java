package kz.ticketon.main_page;

import io.qameta.allure.Story;
import kz.ticketon.BaseClassWebTest;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.MainMenuButtonsMainPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Story("Проверка переходов на страницы разделов через главное меню для разных городов и на разных языках")
public class CheckMainMenyTest extends BaseClassWebTest {
    //генерация исходных данных для теста, комбинации возможных вариантов
    static Stream<Object[]> menuItemsAndCities() {
        List<Object[]> list = new ArrayList<>();
        Arrays.asList(MainMenuButtonsMainPage.values()).forEach(
                item -> Arrays.asList(Cities.values()).forEach(
                        city -> Arrays.asList(Languages.values()).forEach(
                                language -> list.add(new Object[]{item, city, language})
                        )
                )
        );
        return list.stream();
    }

    @ParameterizedTest()
    @MethodSource("menuItemsAndCities")
    public void checkMainMenyRus(
            final MainMenuButtonsMainPage menuItem,
            final Cities city,
            final Languages language) {
        chooseMaimMenu(menuItem, language, city);
    }
}
