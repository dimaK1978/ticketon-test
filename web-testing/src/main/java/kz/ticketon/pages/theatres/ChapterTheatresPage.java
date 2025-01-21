package kz.ticketon.pages.theatres;

import kz.ticketon.Cities;
import kz.ticketon.Languages;
import kz.ticketon.pages.ChapterPage;

public class ChapterTheatresPage extends ChapterPage {
    private final String shortPageUrl = "theatres";

    protected final String pageTitleRus = "Билеты в театр";
    protected final String pageTitleEng = "Theater tickets";
    protected final String pageTitleKz = "Театрға билеттер";


    public ChapterTheatresPage(Cities city, Languages language) {
        super(city, language);
        super.shortPageUrl = shortPageUrl;
        super.pageTitleRus = pageTitleRus;
        super.pageTitleEng = pageTitleEng;
        super.pageTitleKz = pageTitleKz;
    }
}
