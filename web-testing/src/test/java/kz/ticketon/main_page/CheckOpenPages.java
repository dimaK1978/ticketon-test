package kz.ticketon.main_page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import kz.ticketon.BaseClassWebTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Story("Проверка переходов на страницы разделов главного меню")
public class CheckOpenPages extends BaseClassWebTest {

    @Test
    @Description()
    public void checkStartRus(){
        openStartPageRus();
    }

    @Test
    public void checkStartKz(){
        openStartPageKz();
    }

    @Test
    public void checkStartEng(){
        openStartPageEng();
    }
}
