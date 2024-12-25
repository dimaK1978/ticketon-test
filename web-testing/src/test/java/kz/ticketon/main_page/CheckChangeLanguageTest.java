package kz.ticketon.main_page;

import kz.ticketon.BaseClassWebTest;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CheckChangeLanguageTest extends BaseClassWebTest {
    // генерация исходных данных, перебор вариантов переключения языка
    static Stream<Object[]> languages() {
        List<Object[]> list = new ArrayList<>();
        Arrays.asList(Languages.values()).forEach(
                startLanguage -> Arrays.asList(Languages.values()).forEach(
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
            final Languages startPageLanguage,
            final Languages newLanguage
    ) {
        checkChangeLanguageMaim(startPageLanguage, newLanguage, Cities.NO_CITY);
    }
}
