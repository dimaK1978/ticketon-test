package kz.ticketon;

public enum MainPageTitle {
    RU_TITLE("Афиша событий"),
    KZ_TITLE("Оқиғалар постері"),
    EN_TITLE("Event schedule");

    private String titleName;

    MainPageTitle(String titleName) {
        this.titleName = titleName;
    }

    public String getTitleName() {
        return titleName;
    }
}
