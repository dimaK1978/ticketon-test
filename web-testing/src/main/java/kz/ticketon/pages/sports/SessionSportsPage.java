package kz.ticketon.pages.sports;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import kz.ticketon.SleepUtils;
import kz.ticketon.pages.SessionPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class SessionSportsPage extends SessionPage {
    private SelenideElement freeSeatButton = $x("//div[@style='color: rgb(255, 255, 255);']");
    private SelenideElement fullDataSession = $x("//div[@class='timeAndPlace']");
    private ElementsCollection tickets = $$x("//div[@class='ticketWrapper entryTicketComponent']");
    private ElementsCollection ticketsWithoutPlace = $$x("//div[@class='ticketWrapper entryTicketComponent']");
    private SelenideElement sectorOfHall = $("path[stroke='#00bbff']");
    private SelenideElement addTicketButton = $x("//button[@class='button secondary addTicketButton']");

    @Override
    public String getFullDataSessionActual() {
        return fullDataSession.getText();
    }

    @Override
    public int getTicketQantiti() {
        return tickets.size();
    }

    @Override
    public void deleteTicket() {
        if (tickeForm == TickeForm.WITH_PLACE) {
            if (tickets.size() == 0) {
                throw new RuntimeException("Билетов с списке нет");
            }
            tickets.get(0).$("img[alt='закрыть']").click();
            plaseInd--;
        } else {
            if (ticketsWithoutPlace.size() == 0) {
                throw new RuntimeException("Билетов с списке нет");
            }
            ticketsWithoutPlace.get(0).$("img[alt='close']").click();
            plaseInd--;
        }
    }

    public SessionSportsPage(String titleExpect, String time, String day, String month, String movieTheatre) {
        super(titleExpect, time, day, month, movieTheatre);
        titleActual = $x("//div[@class='title']");
        cleanTicket();
    }

    private void cleanTicket() {
        if (tickets.size() != 0) {
            tickets.stream().forEach(ticket -> ticket.$("div[class='closeBtn']").click());
        }
    }

    @Override
    public void clickSeatAddTicket() {
        if (addTicketButton.exists()) {
            addTicketButton.click();
            tickeForm = TickeForm.WITHOUT_PLACE;
        } else {
            if (sectorOfHall.exists()) {
                sectorOfHall.click();
            }
            SleepUtils.sleepSeconds(5);
            if (addTicketButton.exists()) {
                tickeForm = TickeForm.WITHOUT_PLACE;
                if (ticketsWithoutPlace.size() == plaseInd) {
                    addTicketButton.click();
                }
                plaseInd++;
            } else {
                if (!freeSeatButton.exists()) {
                    throw new RuntimeException("Свободных мест нет");
                }
                freeSeatButton.click();
                plaseInd++;
            }
        }
    }
}
