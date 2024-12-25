package kz.ticketon.pages;

import kz.ticketon.Cities;
import kz.ticketon.Languages;

public class ChapterPageCinema extends ChapterPage {

    private final String shortPageUrl = "cinema";

    protected final String pageTitleRus = "Билеты в кино";
    protected final String pageTitleEng = "Movie tickets";
    protected final String pageTitleKz = "Киноға билеттер";

    public ChapterPageCinema(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
}
