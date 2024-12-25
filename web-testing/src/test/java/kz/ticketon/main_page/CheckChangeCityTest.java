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

public class CheckChangeCityTest extends BaseClassWebTest {

    static Stream<Object[]> cities() {
        List<Object[]> list = new ArrayList<>();
        Arrays.asList(Cities.values()).forEach(
                city -> Arrays.asList(Languages.values()).forEach(
                        language -> {
                            {
                                if (city != Cities.NO_CITY) {
                                    list.add(new Object[]{city, language});
                                }
                            }
                        }
                )
        );
        return list.stream();
    }

    @ParameterizedTest()
    @MethodSource(value = "cities()")
    public void checkChangeCity(
            final Cities newCitie,
            final Languages language
    ) {
        checkChangeCityMaim(Cities.NO_CITY, language, newCitie);
    }
}
