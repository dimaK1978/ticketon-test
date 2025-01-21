package kz.ticketon.pages.cinema;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class SessionMovieOldFormPage extends SessionMoviePage{
    private SelenideElement freeSeatButton = $x("//div[@style='color: rgb(255, 255, 255);']");
    private SelenideElement fullDataSession = $x("//div[@class='timeAndPlace']");
    private ElementsCollection tickets = $$x("//div[@class='ticketWrapper desktopTicket']");


    @Override
    public String getFullDataSessionActual(){
        return  fullDataSession.getText();
    }
    @Override
    public int getTicketQantiti(){
        return tickets.size();
    }

    @Override
    public void deleteTicket() {
       if(tickets.size() == 0) {
           throw new RuntimeException("Билетов с списке нет");
       }
        tickets.get(0).$x("//img[@alt='закрыть']").click();
    }
    public SessionMovieOldFormPage(String titleExpect, String time, String day, String month, String movieTheatre, String adres) {
        super(titleExpect, time, day, month, movieTheatre, adres);

        titleActual = $x("//div[@class='title']");

    }
   @Override
    public void clickSeatAddTicket() {
        if (!freeSeatButton.exists()) {
            throw new RuntimeException("Свободных мест нет");
        }
        freeSeatButton.click();
    }
}
