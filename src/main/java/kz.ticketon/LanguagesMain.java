package kz.ticketon;

public enum LanguagesMain {
    RUS("/html/body/div[1]/div/header/div[1]/div[3]/div[2]/div[2]/div/ul/li[1]/a", ""),
    ENG("/html/body/div[1]/div/header/div[1]/div[3]/div[2]/div[2]/div/ul/li[2]/a", "en/"),
    KZ("/html/body/div[1]/div/header/div[1]/div[3]/div[2]/div[2]/div/ul/li[3]/a", "kz/");

    private String webXpath;
    private String urlString;

    LanguagesMain(final String webXpath, final String urlString) {
        this.webXpath = webXpath;
        this.urlString = urlString;
    }

    public String getWebXpath() {

        return webXpath;
    }

    public String getUrlString() {
        return urlString;
    }
}
