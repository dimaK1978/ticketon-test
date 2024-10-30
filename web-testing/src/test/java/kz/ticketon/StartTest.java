package kz.ticketon;

import org.junit.jupiter.api.Test;

public class StartTest extends BaseClassTest {
    @Test
    public void openstart() {
        openStartPage();
        chooseMaimMenuCinema();
        openStartPage();
        chooseMaimMenuTheatres();
        openStartPage();
        chooseMaimMenuConcerts();
        openStartPage();
        chooseLanguageMaim(Languages.KZ);
        int i=1;
    }

}
