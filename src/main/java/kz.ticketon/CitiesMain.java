package kz.ticketon;

public enum CitiesMain {
    NO_CITY("/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/div/a",
            "",
            "Выбор города",
            "Қала тандау",
            "Select city"
    ),
    AKSAI(
            "/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[1]/a ",
            "aksai",
            "Аксай",
            "Ақсай",
            "Aksay"
    ),
    AKTAU(
            "/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[2]/a",
            "aktau",
            "Актау",
            "Ақтау",
            "Aktau"
    ),
    AKTOBE(
            "/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[3]/a",
            "aktobe",
            "Актобе",
            "Ақтөбе",
            "Aktobe"
    ),
    ALMATY(
            "/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[4]/a",
            "almaty",
            "Алматы",
            "Алматы",
            "Almaty"
    ),
    ASTANA(
            "/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[5]/a",
            "astana",
            "Астана",
            "Астана",
            "Astana"
    ),
    ATBASAR(
            "/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[6]/a",
            "atbasar",
            "Атбасар",
            "Атбасар",
            "Atbasar"
    );
    private String webXpath;
    private String urlString;
    private String titleRu;
    private String titleKz;
    private String titleEn;

    CitiesMain(
            final String webXpath,
            final String urlString,
            final String titleRu,
            final String titleKz,
            final String titleEn
    ) {
        this.webXpath = webXpath;
        this.urlString = urlString;
        this.titleRu = titleRu;
        this.titleKz = titleKz;
        this.titleEn = titleEn;
    }

    public String getWebXpath() {

        return webXpath;
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