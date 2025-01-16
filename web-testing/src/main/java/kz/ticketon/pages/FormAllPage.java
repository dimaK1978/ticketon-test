package kz.ticketon.pages;

import com.codeborne.selenide.SelenideElement;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.MainMenuButtonsMainPage;
import kz.ticketon.pages.cinema.ChapterPageCinema;

import static com.codeborne.selenide.Selenide.$x;

public class FormAllPage {
    protected Cities city;
    protected Languages language;

    public FormAllPage(Cities city, Languages language) {
        this.city = city;
        this.language = language;
    }

    //элемент отображения и выбора языка
    private final SelenideElement accordeonLanguage = $x("//div[@class='Languages_wrapperLanguagesBtn__lv3IP']");

    //элемент отображения и выбора города
    private final SelenideElement accordeonCity = $x("//div[@class='CitySelect_markerName__Jzfjc']");


    //смена языка
    public void changeLanguage(Languages newLanguage) {
        if(newLanguage == language) {
            return;
        }
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

    public SelenideElement getAccordeonLanguage() {
        return accordeonLanguage;
    }

    public SelenideElement getAccordeonCity() {
        return accordeonCity;
    }

    public String getCityName() {
        return getCityName(city);
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
                chapterPage = new ChapterPageCinema(city, language);
                break;
            case THEATRES:
                chapterPage = new ChapterPageTheatres(city, language);
                break;
            case CONCERTS:
                chapterPage = new ChapterPageConcerts(city, language);
                break;
            case SPORT:
                chapterPage = new ChapterPageSports(city, language);
                break;
            case CHILDREN:
                chapterPage = new ChapterPageChildren(city, language);
                break;
            case CHRISTMAS_EVENT:
                chapterPage = new ChapterPageChristmasEvent(city, language);
                break;
            default:
                chapterPage = new ChapterPageTours(city, language);
                break;
        }
        return chapterPage;
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
                cityName = MainMenuButton.getButtonNameEn();
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
