package kz.ticketon.pages;

import kz.ticketon.Cities;
import kz.ticketon.Languages;

public class ChapterPageSports extends ChapterPage {
    private final String shortPageUrl = "sports";

    protected final String pageTitleRus = "Билеты на спорт";
    protected final String pageTitleEng = "Sports tickets";
    protected final String pageTitleKz = "Спорт билеттері";

    public ChapterPageSports(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
}
