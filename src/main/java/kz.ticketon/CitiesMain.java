package kz.ticketon;

public enum CitiesMain {
    AKSAI("/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[1]/a ", "aksai"),
    AKTAU("/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[2]/a", "aktau"),
    AKTOBE("/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[3]/a", "aktobe"),
    ALMATY("/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[4]/a", "almaty"),
    ASTANA("/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[5]/a", "astana"),
    ATBASAR("/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[6]/a", "atbasar"),
    ATYRAU("/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[7]/a", "atyrau"),
    BALHASH("/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[8]/a", "balhash"),
    BALYKCHY("/html/body/div[1]/div/header/div[1]/div[3]/div[1]/div[2]/div/ul/li[9]/a", "balykchy");
    private String webXpath;
    private String urlString;

    CitiesMain(String webXpath, String urlString) {
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
