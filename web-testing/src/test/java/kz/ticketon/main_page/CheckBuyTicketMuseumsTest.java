package kz.ticketon.main_page;

import kz.ticketon.BaseClassWebTest;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CheckBuyTicketMuseumsTest extends BaseClassWebTest {

    static Stream<Object[]> cities() {
        List<Object[]> list = new ArrayList<>();
        Arrays.asList(Cities.values()).forEach(
                city -> list.add(new Object[]{city})
        );
        return list.stream();
    }

 /*   @ParameterizedTest()
    @MethodSource(value = "cities()")
    public void checkEventSchedule(Cities citiy) {
        checkBuyTicketMuseums(citiy, Languages.RUS);
    }*/
         @Test
    public void checkEventSchedule() {
         checkBuyTicketMuseums(Cities.ASTANA, Languages.RUS);
}
}


