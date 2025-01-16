package kz.ticketon.pages.cinema;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

public class SessionMoviePage {
    protected final String titleExpect;
    protected final String time;
    protected final String day;
    protected final String month;
    protected final String movieTheatre;
    protected final String adres;
    protected List<String> seats;

    //первый найденный кликабельный элемент свободного места в зале
    protected SelenideElement freeSeatButton;
    //элемент содержащий заголовке формы с названием фильма
    protected SelenideElement titleActual;
    //элемент содержащий название кинотеатра
    protected SelenideElement movieTheatreActual;
    //элемент содержащий дату сеанса
    protected SelenideElement dateActual;

    public SessionMoviePage(String titleExpect, String time, String day, String month, String movieTheatre, String adres) {
        this.titleExpect = titleExpect;
        this.time = time;
        this.day = day;
        this.month = month;
        this.movieTheatre = movieTheatre;
        this.adres = adres;
    }

    @Step("Клик на первое свободное место в зале")
    public void clickSeat() {
        freeSeatButton.click();
    }

    @Step("Получение текста актуального заголовка открывшейся формы с названием фильма")
    public String getTitleActual() {
        return titleActual.getText();
    }

    @Step("Получение текста актуального названия кинотеатра открывшейся формы")
    public String getMovieTheatreActual() {
        return movieTheatreActual.getOwnText();
    }
    @Step("Получение текста актуальной даты сеанса из открывшейся формы")
    public String getDateActual() {
        return  dateActual.getText();
    }
    public String getTitleExpect() {
        return titleExpect;
    }

    public String getDateExpect() {
        return String.format("%s %s в %s", day, month, time);
    }

    public String getMovieTheatreExpect() {
        return movieTheatre;
    }
}
