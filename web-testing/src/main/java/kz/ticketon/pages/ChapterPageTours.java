package kz.ticketon.pages;

import kz.ticketon.Cities;
import kz.ticketon.Languages;

public class ChapterPageTours extends ChapterPage {
    private final String shortPageUrl = "tours";

    protected final String pageTitleRus = "Туры";
    protected final String pageTitleEng = "Tours";
    protected final String pageTitleKz = "Саяхаттар";

    public ChapterPageTours(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
}
