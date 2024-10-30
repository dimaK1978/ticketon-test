package kz.ticketon;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class BaseClassTest {
    protected static String BASIC_URL = "https://ticketon.kz/";
    protected static int TIME_OUT = 10000;


    @BeforeAll
    public static void setUppAll() {
        Configuration.browserSize = "1280x800";
      //  Configuration.pageLoadStrategy = "normal";
        Configuration.timeout = TIME_OUT;
        Configuration.browserCapabilities =
                new ChromeOptions().addArguments("--remote-allow-origins=*");
    }

    @Step("Загрузка стартовой страницы")
    public void openStartPage() {
        open(BASIC_URL);
        webdriver().shouldHave(url(BASIC_URL));
    }
    @Step("Выбор пунката главного меню \"Кино\"")
    public void chooseMaimMenuCinema() {
        $x("/html/body/div[1]/div/header/div[2]/div/nav/ul/li[1]/a").click();
        webdriver().shouldHave(url(BASIC_URL + "cinema"));
    }

    @Step("Выбор пунката главного меню \"Театры\"")
    public void chooseMaimMenuTheatres() {
        $x("/html/body/div[1]/div/header/div[2]/div/nav/ul/li[2]/a").click();
        webdriver().shouldHave(url(BASIC_URL + "theatres"));
    }

    @Step("Выбор пунката главного меню \"Концерты\"")
    public void chooseMaimMenuConcerts() {
        $x("/html/body/div[1]/div/header/div[2]/div/nav/ul/li[3]/a").click();
        open(BASIC_URL);
        webdriver().shouldHave(url(BASIC_URL + "concerts"));
    }

    @Step("Выбор языка на главной странице")
    public void chooseLanguageMaim(final Languages language) {
        $x("/html/body/div[1]/div/header/div[1]/div[3]/div[2]/div[1]").click();
        $x(language.getWebXpath()).click();

        //   webdriver().shouldHave(url(BASIC_URL + "concerts"));
    }
}