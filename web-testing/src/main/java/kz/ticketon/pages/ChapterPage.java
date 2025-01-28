package kz.ticketon.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.Cities;
import kz.ticketon.Languages;

import static com.codeborne.selenide.Selenide.*;

public abstract class ChapterPage {

    protected String shortPageUrl;
    protected Cities city;
    protected Languages language;

    protected String pageTitleRus;
    protected String pageTitleEng;
    protected String pageTitleKz;

    protected final SelenideElement pageTitle = $x("//div[@class='page-title']");
    protected final ElementsCollection movieList = $$x("//div[@class='block-1 list-block']");

    public ChapterPage(Cities city, Languages language) {
        this.city = city;
        this.language = language;
    }

    public void openPage() {
        open(pageUrlCityLanguage());
    }

    public SelenideElement getPageTitle() {
        return pageTitle;
    }



    public String getShortPageUrl() {
        return shortPageUrl;
    }

    public void setShortPageUrl(String shortPageUrl) {
        this.shortPageUrl = shortPageUrl;
    }

    public Cities getCity() {
        return city;
    }

    public void setCity(Cities city) {
        this.city = city;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public String getPageTitleRus() {
        return pageTitleRus;
    }

    public void setPageTitleRus(String pageTitleRus) {
        this.pageTitleRus = pageTitleRus;
    }

    public String getPageTitleEng() {
        return pageTitleEng;
    }

    public void setPageTitleEng(String pageTitleEng) {
        this.pageTitleEng = pageTitleEng;
    }

    public String getPageTitleKz() {
        return pageTitleKz;
    }

    public void setPageTitleKz(String pageTitleKz) {
        this.pageTitleKz = pageTitleKz;
    }

    public String getPageTitleExpected() {
        String title;
        switch (language) {
            case KZ:
                title = getPageTitleKz();
                break;
            case ENG:
                title = getPageTitleEng();
                break;
            default:
                title = getPageTitleRus();
                break;
        }
        return title;
    }

    public String pageUrlCityLanguage() {
        MainPage mainPage = new MainPage(city, language);
        return String.format("%s/%s", mainPage.getPageUrlCityLanguage(), shortPageUrl);
    }

    @Step("Клик на доступное событие")
    public abstract EventPage clickEvent(final SelenideElement movie);

    public abstract EventPage clickFirstEvent();
}
