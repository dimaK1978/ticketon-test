package kz.ticketon.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import kz.ticketon.Cities;
import kz.ticketon.Languages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends FormAllPage {

    private final String BASIC_PAGE_URL = "https://ticketon.kz";

    private final String pageTitleRus = "Афиша событий";
    private final String pageTitleEng = "Event schedule";
    private final String pageTitleKz = "Оқиғалар постері";

    //элемент заголовка страницы
    private final SelenideElement headerEventSchedule = $x("//h1[@class='Title_title__6QR87 Title_h1__YhWT1']");
    private final SelenideElement headerPopular = $x("//h2[@class='PaginatedDetailsListWrapper_header__9WYX3']");


    public MainPage(Cities city, Languages language) {
        super(city, language);
    }

    //открытие страницы
    public void openPage() {
        open(getPageUrlCityLanguage());
    }

    //получение полного заголовка страницы с учетом выбранного языка и города
    public String fullPageTitleCityLanguage() {
        String baseTitle;

        switch (language) {
            case ENG: {
                baseTitle = pageTitleEng;
                break;
            }
            case KZ: {
                baseTitle = pageTitleKz;
                break;
            }
            default: {
                baseTitle = pageTitleRus;
                break;
            }
        }
        return String.format("%s %s", baseTitle, getCityName());
    }

    public SelenideElement getHeaderEventSchedule() {
        return headerEventSchedule;
    }

    public String getPageUrlCityLanguage() {
        String urlStartPage;

        if (language == Languages.RUS) {
            if (city == Cities.NO_CITY) {
                urlStartPage = BASIC_PAGE_URL;
            } else {
                urlStartPage = String.format("%s/%s", BASIC_PAGE_URL, city.getUrlString());
            }
        } else {
            if (city == Cities.NO_CITY) {
                urlStartPage = String.format("%s/%s", BASIC_PAGE_URL, language.getUrlString());
            } else {
                urlStartPage = String.format(
                        "%s/%s/%s",
                        BASIC_PAGE_URL,
                        language.getUrlString(),
                        city.getUrlString()
                );
            }
        }
        return urlStartPage;
    }
}
