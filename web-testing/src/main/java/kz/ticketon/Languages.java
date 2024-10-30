package kz.ticketon;

public enum Languages {
    RUS("/html/body/div[1]/div/header/div[1]/div[3]/div[2]/div[2]/div/ul/li[1]/a"),
    ENG("/html/body/div[1]/div/header/div[1]/div[3]/div[2]/div[2]/div/ul/li[2]/a"),
    KZ("/html/body/div[1]/div/header/div[1]/div[3]/div[2]/div[2]/div/ul/li[3]/a");

    Languages(String webXpath) {
        this.webXpath = webXpath;
    }

    private String webXpath;

    public String getWebXpath() {
        return webXpath;
    }
}
