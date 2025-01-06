package kz.ticketon.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import kz.ticketon.Cities;
import kz.ticketon.Languages;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class EventPageCinema extends FormAllPage {

    private String title;
    final SelenideElement buttonBuyTicket = $x("//button[@class='Button_button__HYetI Button_padding__4Kuri BuyButton_button__Mey4J']");
    final ElementsCollection availableSessions = $$x("//div[@class='ScheduleRow_scheduleRow__o3xf2']");

    final SelenideElement titleEvent = $x("//h1");

    public EventPageCinema(final Cities city, final Languages language, final String title) {
        super(city, language);
        this.title = title;
    }

    public SessionMoviePage getFirstSessionMovie(){
        return getSessionMovie(availableSessions.first());
    }
    public SessionMoviePage getSessionMovie(SelenideElement selenideElement){
        final SelenideElement buttonSession = selenideElement.find("span[class='TicketButton_text__HwCFn']");

        final String time = buttonSession.getOwnText();
        final String day = selenideElement.find("div[class='Date_day__GAPLg']").getText();
        final String month = selenideElement.find("div[class='Date_dateText__h6416']").$(new By.ByTagName("div")).getText();
        final String movieTheatre = selenideElement.find("div[class='CinemaInfo_cinemaName___Escv']").getText();
        final String adres = selenideElement.find("div[class='CinemaInfo_address__jpAG6']").getText();
        buttonSession.click();
        return new SessionMoviePage(title, time, day, month, movieTheatre, adres);
    }

    public String getTitleActual() {
        return titleEvent.getText();
    }

    public String getTitleExpect() {
        return title;
    }

}
