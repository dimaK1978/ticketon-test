package kz.ticketon.pages;

import kz.ticketon.Cities;
import kz.ticketon.Languages;

public class ChapterPageTheatres extends ChapterPage {
    private final String shortPageUrl = "theatres";

    protected final String pageTitleRus = "Билеты в театр";
    protected final String pageTitleEng = "Theater tickets";
    protected final String pageTitleKz = "Театрға билеттер";


    public ChapterPageTheatres(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
}
