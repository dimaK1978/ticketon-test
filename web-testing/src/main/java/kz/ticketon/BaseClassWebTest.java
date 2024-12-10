package kz.ticketon;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.util.Assert;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class BaseClassWebTest extends BaseClassTest {

    protected static String BASIC_URL = "https://ticketon.kz";
    protected static int TIME_OUT = 20000;


    @BeforeAll
    public static void setUppAll() {
        Configuration.browserSize = "1280x800";
        //  Configuration.pageLoadStrategy = "normal";
        Configuration.timeout = TIME_OUT;
        Configuration.browserCapabilities =
                new ChromeOptions().addArguments("--remote-allow-origins=*");
    }


    @Step("Загрузка главной страницы в зависимости от выбранного языка и города")
    public String openMainPage(final LanguagesMain language, final CitiesMain city) {
        String urlStartPage = createUrlStartPageForLanguageAndCity(language, city);
        open(urlStartPage);
        return urlStartPage;
    }

    @Step("Переход на страницы через пункаты главного меню с учетом выбора города и языка")
    public void chooseMaimMenu(
            final MaimMenuMainPage menuItem,
            final LanguagesMain language,
            final CitiesMain city
    ) {
        final String urlStartPage = openMainPage(language, city);
        final String expectedOpenPage = urlStartPage + "/" + menuItem.getUrlString();
        $x(menuItem.getXpathWeb()).click();
        webdriver().shouldHave(url(expectedOpenPage));
        final String actualTitle = $("div[class='page-title']").getText();
        final String expectedTitle = getTitleMenuItemPage(menuItem, language);
        Assert.isTrue(actualTitle.equals(expectedTitle),"Заголовок страницы не совпадает с ожидаемым");
    }

    @Step("Проверка переключения языка главной страницы с одного на другой")
    public void chooseLanguageMaim(
            final LanguagesMain startPageLanguage,
            final LanguagesMain newLanguage,
            final CitiesMain city
    ) {
        openMainPage(startPageLanguage, city);
        changeLanguageMaim(newLanguage, city);
    }

    @Step("Выбор языка главной странице")
    public void changeLanguageMaim(final LanguagesMain newLanguage, final CitiesMain city) {
        $("div[class='Languages_wrapperLanguagesBtn__lv3IP']").click();
        $x(newLanguage.getxPath()).click();
        if (newLanguage == LanguagesMain.RUS) {
            webdriver().shouldHave(url(openMainPage(newLanguage, city) + "/"));
        } else {
            webdriver().shouldHave(url(openMainPage(newLanguage, city)));
        }
        final String actualText = $("div[class='Languages_wrapperLanguagesBtn__lv3IP']").getOwnText();

        Assert.isTrue(
                actualText.equals(newLanguage.getDisplyName()),
                "отображение языка страницы не соответсвует ожиданиям"
        );
    }
    //@Step("Смена города")
    //  /html/body/div[1]/div/header/div[1]/div[3]/div[1]/div/svg

    /*    @Step("Проветка перехода на страницy события аффиши при клике на его иконку")
        public void chooseEventScheduleMaim(final LanguagesMain language) {
            openStartPage(language);
            SelenideElement wind1 = $("div[class='FullScreenDetailedCard_content__pxOGG FullScreenDetailedCard_backgroundOverlay__ceXQ5']");//.click();
            final String xz = wind1.find("div[class='FullScreenDetailedCard_eventTitle__PpM1W']").getOwnText();
            wind1.doubleClick();
            String s = $("div[class='_ontentDetails_title__uUkkl']").find("h1").getText();
            Assert.isTrue(xz.equals(s), "Заголовок иконки не совпдает с заголовком страницы события");
        }*/
//генерация ожидаемого одреса главной страницы с учетом выбранного города и языка
    private String createUrlStartPageForLanguageAndCity(final LanguagesMain language, final CitiesMain city) {
        String urlStartPage;

        if (language == LanguagesMain.RUS) {
            if (city == CitiesMain.NO_CITY) {
                urlStartPage = BASIC_URL;
            } else {
                urlStartPage = String.format("%s/%s", BASIC_URL, city.getUrlString());
            }
        } else {
            if (city == CitiesMain.NO_CITY) {
                urlStartPage = String.format("%s/%s", BASIC_URL, language.getUrlString());
            } else {
                urlStartPage = String.format(
                        "%s/%s/%s",
                        BASIC_URL,
                        language.getUrlString(),
                        city.getUrlString()
                );
            }
        }
        return urlStartPage;
    }

    private String getTitleMenuItemPage(final MaimMenuMainPage menuItem, final LanguagesMain language) {
        String title;
        if (language == LanguagesMain.RUS) {
            title = menuItem.getTitleRu();
        } else if (language == LanguagesMain.KZ) {
            title = menuItem.getTitleKz();
        } else {
            title = menuItem.getTitleEn();
        }
        return title;
    }

    @AfterEach
    public void tearDownBrowser() {
        Selenide.closeWebDriver();
    }
}