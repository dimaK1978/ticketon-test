package kz.ticketon.pages.cinema;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.pages.ChapterPage;
import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$$x;

public class ChapterCinemaPage extends ChapterPage {

    private final String shortPageUrl = "cinema";

    private final String pageTitleRus = "Билеты в кино";
    private final String pageTitleEng = "Movie tickets";
    private final String pageTitleKz = "Киноға билеттер";

    private ElementsCollection movieList = $$x("//div[@class='block-1 list-block']");


    public ChapterCinemaPage(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }

    @Step("Клик на доступный фильм")
    public EventPageCinema clickMovie(final SelenideElement movie) {
        final String titleMovie = movie.$(new By.ByTagName("a")).getAttribute("title");
        movie.scrollTo().click();
        return new EventPageCinema(city, language, titleMovie);
    }

    public EventPageCinema clickFirstMovie() {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (movieList.isEmpty()) {
            throw new RuntimeException("Доступных фильмов нет");
        }
        return clickMovie(movieList.first());
    }
}
