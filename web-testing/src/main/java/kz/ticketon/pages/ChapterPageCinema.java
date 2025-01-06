package kz.ticketon.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class ChapterPageCinema extends ChapterPage {

    private final String shortPageUrl = "cinema";

    private final String pageTitleRus = "Билеты в кино";
    private final String pageTitleEng = "Movie tickets";
    private final String pageTitleKz = "Киноға билеттер";

    private ElementsCollection movieList = $$x("//div[@class='block-1 list-block']");


    public ChapterPageCinema(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }

    public EventPageCinema clickMovie(final SelenideElement movie) {
        final String titleMovie = movie.$(new By.ByTagName("a")).getAttribute("title");
        movie.click();
       return new EventPageCinema(city, language, titleMovie);
    }

    public EventPageCinema clickFirstMovie() {
        return clickMovie(movieList.first());
    }
}
