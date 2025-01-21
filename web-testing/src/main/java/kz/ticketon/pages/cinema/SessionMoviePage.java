package kz.ticketon.pages.cinema;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.ArrayList;
import java.util.List;

public abstract class SessionMoviePage {
    protected final String titleExpect;
    protected final String time;
    protected final String day;
    protected final String month;
    protected final String movieTheatre;
    protected final String adres;
    protected List<String> seats;
     //элемент содержащий заголовке формы с названием фильма
    protected SelenideElement titleActual;

    public SessionMoviePage(String titleExpect, String time, String day, String month, String movieTheatre, String adres) {
        this.titleExpect = titleExpect;
        this.time = time;
        this.day = day;
        this.month = month;
        this.movieTheatre = movieTheatre;
        this.adres = adres;
        seats = new ArrayList<>();
    }

    @Step("Клик на свободное место в зале - добавление билета")
    public abstract void clickSeatAddTicket();

    @Step("Удаление выбранного билета")
    public abstract void deleteTicket();

    @Step("Получение текста актуального заголовка открывшейся формы с названием фильма")
    public String getTitleActual() {
        return titleActual.getText();
    }

    @Step("Получение ожидаемого текста заголовка с названием фильма")
    public String getTitleExpect() {
        return titleExpect;
    }

    @Step("Получение ожидаемого текста данных о сеансе с временем, датой и кинотеатром")
    public String getFullDataSessionExpect() {
        return String.format("%s %s в %s, %s", day, month, time, movieTheatre);
    }

    @Step("Получение текста данных о сеансе с временем, датой и кинотеатром из открывшейся формы")
    public abstract String getFullDataSessionActual();

    @Step("Получение количества выбранных билетов")
    public abstract int getTicketQantiti();

}
