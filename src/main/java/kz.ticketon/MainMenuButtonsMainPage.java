package kz.ticketon;

public enum MainMenuButtonsMainPage {

    CINEMA("Кино", "Movie", "Кино"),
    THEATRES("Театры", "Theaters", "Театрлар"),
    CONCERTS("Концерты", "Concert", "Концерт"),
    SPORT("Спорт", "Sport", "Спорт"),
    CHILDREN("Детям","Children","Балаларға"),
    CHRISTMAS_EVENT("Ёлки","Christmas Events","Жана-Жыл"),
    TOURS("Туры","Tours","Турлар");
   /* MASTER_CLASSES(
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
    );*/

    private String buttonNameRu;
    private String buttonNameEn;
    private String buttonNameKz;

    MainMenuButtonsMainPage(String buttonNameRu, String buttonNameEn, String buttonNameKz) {
        this.buttonNameRu = buttonNameRu;
        this.buttonNameEn = buttonNameEn;
        this.buttonNameKz = buttonNameKz;
    }

    public String getButtonNameRu() {
        return buttonNameRu;
    }

    public String getButtonNameEn() {
        return buttonNameEn;
    }

    public String getButtonNameKz() {
        return buttonNameKz;
    }
}
