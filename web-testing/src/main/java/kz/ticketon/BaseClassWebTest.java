package kz.ticketon;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class BaseClassWebTest extends BaseClassTest {

    protected static String BASIC_URL = "https://ticketon.kz/";
    protected static int TIME_OUT = 20000;


    @BeforeAll
    public static void setUppAll() {
        Configuration.browserSize = "1280x800";
        //  Configuration.pageLoadStrategy = "normal";
        Configuration.timeout = TIME_OUT;
        Configuration.browserCapabilities =
                new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Step("Загрузка стартовой страницы")
    public void openStartPage(final LanguagesMain language) {
        open(BASIC_URL + language.getUrlString());
        webdriver().shouldHave(url(BASIC_URL + language.getUrlString()));
    }

    @Step("Загрузка стартовой страницы на русском")
    public void openStartPageRus() {
        openStartPage(LanguagesMain.RUS);
    }

    @Step("Загрузка стартовой страницы на английском")
    public void openStartPageEng() {
        openStartPage(LanguagesMain.ENG);
    }

    @Step("Загрузка стартовой страницы на казахском")
    public void openStartPageKz() {
        openStartPage(LanguagesMain.KZ);
    }

    @Step("Выбор пунката главного меню")
    public void chooseMaimMenu(final MaimMenuMain menuItem, final LanguagesMain language) {
        openStartPage(language);
        $x(menuItem.getXpathWeb()).click();
        webdriver().shouldHave(url(BASIC_URL + language.getUrlString() + menuItem.getUrlWebUnderBasic()));
    }


    @Step("Выбор языка на главной странице")
    public void chooseLanguageMaim(final LanguagesMain language) {
        openStartPageRus();
        $x("/html/body/div[1]/div/header/div[1]/div[3]/div[2]/div[1]").click();
        $x(language.getWebXpath()).click();
        webdriver().shouldHave(url(BASIC_URL + language.getUrlString()));
    }
}