package kz.ticketon.pages.theatres;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import kz.ticketon.pages.SessionPage;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.*;

public class SessionThatrePlayPage extends SessionPage {
    private SelenideElement freeSeatButton = $x("//div[@style='color: rgb(255, 255, 255);']");
    private SelenideElement fullDataSession = $x("//div[@class='timeAndPlace']");
    private ElementsCollection tickets = $$x("//div[@class='ticketWrapper desktopTicket']");
    private SelenideElement sectorOfHall = $("path[stroke='#00bbff']");

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
        if (tickets.size() == 0) {
            throw new RuntimeException("Билетов с списке нет");
        }
        tickets.get(0).$("img[alt='закрыть']").click();
    }

    public SessionThatrePlayPage(String titleExpect, String time, String day, String month, String movieTheatre) {
        super(titleExpect, time, day, month, movieTheatre);
        titleActual = $x("//div[@class='title']");
    }

    @Override
    public void clickSeatAddTicket() {
        if (sectorOfHall.exists()) {
            sectorOfHall.click();
        }

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (!freeSeatButton.exists()) {
            throw new RuntimeException("Свободных мест нет");
        }
        freeSeatButton.click();
    }
}
