package kz.ticketon.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.MainMenuButtonsMainPage;
import kz.ticketon.pages.cinema.ChapterCinemaPage;
import kz.ticketon.pages.theatres.ChapterTheatresPage;

import static com.codeborne.selenide.Selenide.$x;

public class BaseTemlatePage {

    protected Cities city;
    protected Languages language;

    public BaseTemlatePage(Cities city, Languages language) {
        this.city = city;
        this.language = language;
    }

    //элемент отображения и выбора языка
    private final SelenideElement accordeonLanguage = $x("//div[@class='Languages_wrapperLanguagesBtn__lv3IP']");

    //элемент отображения и выбора города
    private final SelenideElement accordeonCity = $x("//div[@class='CitySelect_markerName__Jzfjc']");

    //элемент поиска событий
    private final SelenideElement searchEventForm =$x("//input[@class='SearchInput_isEmpty__wgMBa']");
private final SelenideElement findeButton =$x("//img[@src='/rrs/_next/static/media/loupe.11a27ae1.svg']");

    @Step("смена языка")
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

    @Step("смена города")
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

    @Step("Поиск события")
    public SearchResultPage searchEvent(String eventTitle) {
        searchEventForm.scrollTo().sendKeys(eventTitle);
        findeButton.click();
        return new SearchResultPage(city, language);
    }

    @Step("Получение текста элемента отображения языка страницы")
    public String getActualLanguageText() {
        return accordeonLanguage.getOwnText();
    }

    @Step("Получение текста элемента отображения города на странице")
    public String getActualShowCity() {
        return accordeonCity.getOwnText();
    }

    public String getCityName() {
        return getCityName(city);
    }

    @Step("выбор пункта главного меню")
    public ChapterPage clickMainMenuButton(MainMenuButtonsMainPage mainMenuButton) {
        $x(String.format(
                "//a[@class='NavigationItem_navigationLink__cSZrB' and contains(text(),'%s')] ",
                getMainMenuButtonName(mainMenuButton)
        )).click();
        ChapterPage chapterPage;
        switch (mainMenuButton) {
            case CINEMA:
                chapterPage = new ChapterCinemaPage(city, language);
                break;
            case THEATRES:
                chapterPage = new ChapterTheatresPage(city, language);
                break;
            case CONCERTS:
                chapterPage = new ChapterPageConcerts(city, language);
                break;
            case SPORT:
                chapterPage = new ChapterPageSports(city, language);
                break;
            case CHILDREN:
                chapterPage = new ChapterChildrenPage(city, language);
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

   protected String getMainMenuButtonName(MainMenuButtonsMainPage MainMenuButton) {
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
