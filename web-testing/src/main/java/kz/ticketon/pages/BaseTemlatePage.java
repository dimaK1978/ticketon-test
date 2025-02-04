package kz.ticketon.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.MainMenuButtonsMainPage;
import kz.ticketon.SleepUtils;
import kz.ticketon.pages.children.ChapterChildrenPage;
import kz.ticketon.pages.christmas_event.ChapterChristmasEventPage;
import kz.ticketon.pages.cinema.ChapterCinemaPage;
import kz.ticketon.pages.concerts.ChapterConcertsPage;
import kz.ticketon.pages.entertainment.ChapterEntertainmentPage;
import kz.ticketon.pages.master_classes.ChapterMasterClassesPage;
import kz.ticketon.pages.museums.ChapterMuseumsPage;
import kz.ticketon.pages.sports.ChapterSportsPage;
import kz.ticketon.pages.theatres.ChapterTheatresPage;
import kz.ticketon.pages.tours.ChapterPageTours;

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
    private final SelenideElement searchEventForm = $x("//input[@class='SearchInput_isEmpty__wgMBa']");
    //элемент кнопка запуска поиска событий
    private final SelenideElement searchButton = $x("//img[@src='/rrs/_next/static/media/loupe.11a27ae1.svg']");

    @Step("Смена языка страницы")
    public void changeLanguage(Languages newLanguage) {
        if (newLanguage == language) {
            return;
        }
        accordeonLanguage.click();
        $x(String.format(
                "//a[@class='DropdownListItem_listItemLink___X5tk' and contains(text(),'%s')]",
                newLanguage.getDisplyName()
        )).click();
        this.language = newLanguage;
    }

    @Step("Смена города")
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
        SleepUtils.sleepSeconds(5);
        searchEventForm.scrollTo().sendKeys(eventTitle);
        SleepUtils.sleepSeconds(5);
        searchButton.click();
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

    @Step("Получение ожидаемого имени города страницы")
    public String getCityName() {
        return getCityName(city);
    }

    @Step("Переход на страницу выбранного раздела главного меню нажатием на соответсвующую кнопку")
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
                chapterPage = new ChapterConcertsPage(city, language);
                break;
            case SPORT:
                chapterPage = new ChapterSportsPage(city, language);
                break;
            case CHILDREN:
                chapterPage = new ChapterChildrenPage(city, language);
                break;
            case CHRISTMAS_EVENT:
                chapterPage = new ChapterChristmasEventPage(city, language);
                break;
            case MASTER_CLASSES:
                chapterPage = new ChapterMasterClassesPage(city, language);
                break;
            case MUSEUMS:
                chapterPage = new ChapterMuseumsPage(city, language);
                break;
            case ENTERTAIMENT:
                chapterPage = new ChapterEntertainmentPage(city, language);
                break;
            default:
                chapterPage = new ChapterPageTours(city, language);
                break;
        }
        return chapterPage;
    }

    @Step("Имя города на языке страницы")
    public String getCityName(Cities city) {
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
