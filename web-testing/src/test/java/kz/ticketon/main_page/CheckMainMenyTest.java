package kz.ticketon.main_page;

import io.qameta.allure.Description;
import io.qameta.allure.Story;
import kz.ticketon.BaseClassWebTest;
import kz.ticketon.LanguagesMain;
import kz.ticketon.MaimMenuMain;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@Story("Проверка переходов на страницы разделов главного меню")
public class CheckMainMenyTest extends BaseClassWebTest {
    @Test
    @Description("язык ссайта выбран русский")
    public void checkMainMenyRus() {
        openStartPageRus();
        Arrays.asList(MaimMenuMain.values()).forEach(item -> {
                    openStartPageRus();
                    chooseMaimMenu(item, LanguagesMain.RUS);
                }
        );
    }

    @Test
    @Description("язык ссайта выбран английский")
    public void checkMainMenyEng() {
        openStartPageEng();
        Arrays.asList(MaimMenuMain.values()).forEach(item -> {
                    openStartPageEng();
                    chooseMaimMenu(item, LanguagesMain.ENG);
                }
        );
    }

    @Test
    @Description("язык ссайта выбран казахский")
    public void checkMainMenyKz() {
        openStartPageKz();
        Arrays.asList(MaimMenuMain.values()).forEach(item -> {
                    openStartPageKz();
                    chooseMaimMenu(item, LanguagesMain.KZ);
                }
        );
    }
}
