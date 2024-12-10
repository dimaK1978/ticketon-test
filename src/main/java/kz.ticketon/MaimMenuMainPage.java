package kz.ticketon;

public enum MaimMenuMainPage {

    CINEMA(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[1]/a",
            "cinema",
            "Билеты в кино",
            "Киноға билеттер",
            "Movie tickets"
    ),
    THEATRES(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[2]/a",
            "theatres",
            "Билеты в театр",
            "Театрға билеттер",
            "Theater tickets"
    ),

    CONCERTS(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[3]/a",
            "concerts",
            "Билеты на концерт",
            "Концертке билеттер",
            "Concert tickets"
    ),
    SPORT(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[4]/a",
            "sports",
            "Билеты на спорт",
            "Спорт билеттері",
            "Sports tickets"
    ),
    CHILDREN(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[5]/a",
            "children",
            "Билеты детям",
            "Балаларға билеттер",
            "Children tickets"
    ),

    CHRISTMAS_EVENT(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[6]/a",
            "christmas-event",
            "Новогодние события",
            "ЖАНА-ЖЫЛ",
            "Christmas Event"
    ),
    TOURS(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[7]/a",
            "tours",
            "Туры",
            "Саяхаттар",
            "Tours"
    ),
    MASTER_CLASSES(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[8]/a",
            "master-classes",
            "Мастер-классы",
            "Мастер-класстар",
            "Master classes"
    ),
    MUSEUMS(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[9]/a",
            "museums",
            "Музеи",
            "Мұражайлар",
            "Museums tickets"
    ),

    ENTERTAIMENT(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[10]/a",
                    "entertainment",
            "Развлечения",
            "Ойын-сауықтар",
            "Entertainment"
    );

    private String xpathWeb;
    private String urlString;
    private String titleRu;
    private String titleKz;
    private String titleEn;

    MaimMenuMainPage(
            final String xpathWeb,
            final String urlWebUnderBasic,
            final String titleRu,
            final String titleKz,
            final String titleEn
    ) {
        this.xpathWeb = xpathWeb;
        this.urlString = urlWebUnderBasic;
        this.titleRu = titleRu;
        this.titleKz = titleKz;
        this.titleEn = titleEn;
    }
    public String getXpathWeb() {

        return xpathWeb;
    }

    public String getUrlString() {

        return urlString;
    }

    public String getTitleRu() {
        return titleRu;
    }

    public String getTitleKz() {
        return titleKz;
    }

    public String getTitleEn() {
        return titleEn;
    }
}
