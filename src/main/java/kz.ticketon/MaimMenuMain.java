package kz.ticketon;

public enum MaimMenuMain {

    CINEMA(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[1]/a",
            "cinema"
    ),
    THEATRES(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[2]/a",
            "theatres"
    ),

    CONCERTS(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[3]/a",
            "concerts"
    ),
    SPORT(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[4]/a",
            "sports"
    ),
    CHILDREN(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[5]/a",
            "children"
    ),

    CHRISTMAS_EVENT(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[6]/a",
            "christmas-event"
    ),
    TOURS(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[7]/a",
            "tours"
    ),
    MASTER_CLASSES(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[8]/a",
            "master-classes"
    ),
    MUSEUMS(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[9]/a",
            "museums"
    ),

    ENTERTAIMENT(
            "/html/body/div[1]/div/header/div[2]/div/nav/ul/li[10]/a",
                    "entertainment"
    );

    private String xpathWeb;
    private String urlWebUnderBasic;

    MaimMenuMain(String xpathWeb, String urlWebUnderBasic) {
        this.xpathWeb = xpathWeb;
        this.urlWebUnderBasic = urlWebUnderBasic;
    }
    public String getXpathWeb() {
        return xpathWeb;
    }

    public String getUrlWebUnderBasic() {
        return urlWebUnderBasic;
    }
}
