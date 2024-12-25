package kz.ticketon.pages;

import com.codeborne.selenide.SelenideElement;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.MainMenuButtonsMainPage;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final String BASIC_PAGE_URL = "https://ticketon.kz";
    private Cities city;
    private Languages language;

    private final String pageTitleRus = "Афиша событий";
    private final String pageTitleEng = "Event schedule";
    private final String pageTitleKz = "Оқиғалар постері";

    private final SelenideElement pageTitle = $("h1[class='Title_title__6QR87 Title_h1__YhWT1']");

    private final SelenideElement accordeonLanguage = $("div[class='Languages_wrapperLanguagesBtn__lv3IP']");

    //
    private final SelenideElement accordeonCity = $("div[class='CitySelect_markerName__Jzfjc']");

    //смена языка
    public void changeLanguage(Languages newLanguage) {
        accordeonLanguage.click();
        $x(String.format(
                "//a[@class='DropdownListItem_listItemLink___X5tk' and contains(text(),'%s')]",
                newLanguage.getDisplyName()
        )).click();
       this.language = newLanguage;
    }


    //смена города
    public void changeSity(Cities newCity) {
        if (city == newCity) {
            return;
        }
        accordeonCity.click();
        $x(String.format(
                        "//a[@class='DropdownListItem_listItemLink___X5tk' and contains(text(),'%s')]",
                        getCityName(newCity)
                )).click();
        this.city = newCity;
    }

    //выбор пункта главного меню
    public ChapterPage clickMainMenuButton(MainMenuButtonsMainPage mainMenuButton) {
        $x(String.format(
                "//a[@class='NavigationItem_navigationLink__cSZrB' and contains(text(),'%s')] ",
                getMainMenuButtonName(mainMenuButton)
        )).click();
        ChapterPage chapterPage;
        switch (mainMenuButton) {
            case CINEMA:
                chapterPage = new ChapterPageCinema(city,language);
                break;
            case THEATRES:
                chapterPage = new ChapterPageTheatres(city,language);
                break;
            case CONCERTS:
                chapterPage = new ChapterPageConcerts(city,language);
                break;
            case SPORT:
                chapterPage = new ChapterPageSports(city,language);
                break;
            case CHILDREN:
                chapterPage = new ChapterPageChildren(city,language);
                break;
            case CHRISTMAS_EVENT:
                chapterPage = new ChapterPageChristmasEvent(city,language);
                break;
            default:
                chapterPage = new ChapterPageTours(city,language);
                break;
        }
        return chapterPage;
    }

    public MainPage(Cities city, Languages language) {
        this.city = city;
        this.language = language;
    }

    public void openPage() {
        open(getPageUrlCityLanguage());
    }


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

    public SelenideElement getAccordeonLanguage() {
        return accordeonLanguage;
    }

    public SelenideElement getPageTitle() {
        return pageTitle;
    }

    public SelenideElement getAccordeonCity() {
        return accordeonCity;
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

    public String getCityName() {
        return getCityName(city);
    }

    private String getCityName(Cities city) {
        String cityName;
        switch (language) {
            case ENG: {
                cityName = city.getTitleEn();
                break;
            }
            case KZ: {
                cityName = city.getTitleKz();
                break;
            }
            default: {
                cityName = city.getTitleRu();
                break;
            }
        }
        return cityName;
    }
    public String getMainMenuButtonName(MainMenuButtonsMainPage MainMenuButton) {
        String cityName;
        switch (language) {
            case ENG: {
                cityName =MainMenuButton.getButtonNameEn();
                break;
            }
            case KZ: {
                cityName = MainMenuButton.getButtonNameKz();
                break;
            }
            default: {
                cityName = MainMenuButton.getButtonNameRu();
                break;
            }
        }
        return cityName;
    }
}
