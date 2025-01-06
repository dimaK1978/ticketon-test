package kz.ticketon.main_page;
import kz.ticketon.BaseClassWebTest;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CheckBuyTicketMovie extends  BaseClassWebTest {

    static Stream<Object[]> cities() {
        List<Object[]> list = new ArrayList<>();
        Arrays.asList(Cities.values()).forEach(
                city -> list.add(new Object[]{city})
        );
        return list.stream();
    }
   /* @ParameterizedTest()
    @MethodSource(value = "cities()")*/
    @Test
    public void checkEventSchedule() {
        checkBuyTicketMovie(Cities.NO_CITY, Languages.RUS);
    }
}
