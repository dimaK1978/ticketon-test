package kz.ticketon.main_page;

import kz.ticketon.BaseClassWebTest;
import kz.ticketon.CitiesMain;
import kz.ticketon.LanguagesMain;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CheckChangeLanguageTest extends BaseClassWebTest {
    // исходные данные, перебор вариантов переключения языка
    static Stream<Object[]> languages() {
        List<Object[]> list = new ArrayList<>();
        Arrays.asList(LanguagesMain.values()).forEach(
                startLanguage -> Arrays.asList(LanguagesMain.values()).forEach(
                        newLanguage -> {
                            if (startLanguage != newLanguage) {
                                list.add(new Object[]{startLanguage, newLanguage});
                            }
                        }
                )
        );
        return list.stream();
    }

    @ParameterizedTest()
    @MethodSource(value = "languages()")
    public void checkChangeLanguage(
            final LanguagesMain startPageLanguage,
            final LanguagesMain newLanguage
    ) {
        chooseLanguageMaim(startPageLanguage, newLanguage, CitiesMain.NO_CITY);
    }
}
