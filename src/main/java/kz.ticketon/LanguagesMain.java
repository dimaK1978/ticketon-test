package kz.ticketon;

public enum LanguagesMain {
    RUS("", "Рус", "/html/body/div[1]/div/header/div[1]/div[3]/div[2]/div[2]/div/ul/li[1]/a"),
    ENG("en", "Eng", "/html/body/div[1]/div/header/div[1]/div[3]/div[2]/div[2]/div/ul/li[2]/a"),
    KZ("kz", "Қаз", "/html/body/div[1]/div/header/div[1]/div[3]/div[2]/div[2]/div/ul/li[3]/a");

    private String urlString;

    private String displyName;
    private String xPath;

    LanguagesMain(final String urlString, final String displyName, final String xPath) {
        this.urlString = urlString;
        this.displyName = displyName;
        this.xPath = xPath;
    }

    public String getUrlString() {

        return urlString;
    }

    public String getDisplyName() {

        return displyName;
    }

    public String getxPath() {

        return xPath;
    }
}
