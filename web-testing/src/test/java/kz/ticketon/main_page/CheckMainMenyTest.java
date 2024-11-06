package kz.ticketon.main_page;

import kz.ticketon.BaseClassWebTest;
import kz.ticketon.LanguagesMain;
import kz.ticketon.MaimMenuMain;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.Arrays;

@Execution(ExecutionMode.SAME_THREAD)
public class CheckMainMenyTest extends BaseClassWebTest {
    @Test
    public void checkMainMenyRus() {
        openStartPageRus();
        Arrays.asList(MaimMenuMain.values()).forEach(item -> {
                    openStartPageRus();
                    chooseMaimMenu(item, LanguagesMain.RUS);
                }
        );
    }

    @Test
    public void checkMainMenyEng() {
        openStartPageEng();
        Arrays.asList(MaimMenuMain.values()).forEach(item -> {
                    openStartPageEng();
                    chooseMaimMenu(item, LanguagesMain.ENG);
                }
        );
    }

    @Test
    public void checkMainMenyKz() {
        openStartPageKz();
        Arrays.asList(MaimMenuMain.values()).forEach(item -> {
                    openStartPageKz();
                    chooseMaimMenu(item, LanguagesMain.KZ);
                }
        );
    }

}
