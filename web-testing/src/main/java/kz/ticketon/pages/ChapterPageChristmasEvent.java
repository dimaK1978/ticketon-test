package kz.ticketon.pages;

import kz.ticketon.Cities;
import kz.ticketon.Languages;

public class ChapterPageChristmasEvent extends ChapterPage {
    private final String shortPageUrl = "christmas-event";
    protected final String pageTitleRus = "Новогодние события";
    protected final String pageTitleEng = "Christmas Event";
    protected final String pageTitleKz = "ЖАНА-ЖЫЛ";

    public ChapterPageChristmasEvent(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
}
