package kz.ticketon.pages;

import kz.ticketon.Cities;
import kz.ticketon.Languages;

public class ChapterPageChildren extends ChapterPage {

    private final String shortPageUrl = "children";
    protected final String pageTitleRus = "Билеты детям";
    protected final String pageTitleEng = "Children tickets";
    protected final String pageTitleKz = "Балаларға билеттер";

    public ChapterPageChildren(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
}
