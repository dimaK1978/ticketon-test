package kz.ticketon.pages;

public class SessionMoviePage {

    private final String title;
    private final String time;
    private final String day;
    private final String month;
    private final String movieTheatre;
    private final String adres;

    public SessionMoviePage(String title, String time, String day, String month, String movieTheatre, String adres) {
        this.title = title;
        this.time = time;
        this.day = day;
        this.month = month;
        this.movieTheatre = movieTheatre;
        this.adres = adres;
    }
}
