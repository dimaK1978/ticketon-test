package kz.ticketon.pages;

import kz.ticketon.Cities;
import kz.ticketon.Languages;

public class ChapterPageConcerts extends ChapterPage {
    private final String shortPageUrl = "concerts";

    protected final String pageTitleRus = "Билеты на концерт";
    protected final String pageTitleEng = "Concert tickets";
    protected final String pageTitleKz = "Концертке билеттер";


    public ChapterPageConcerts(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
}
