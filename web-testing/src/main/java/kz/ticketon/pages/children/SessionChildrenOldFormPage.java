package kz.ticketon.pages.children;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import kz.ticketon.SleepUtils;
import kz.ticketon.pages.MakingOrderOldFormPage;
import kz.ticketon.pages.MakingOrderPage;
import kz.ticketon.pages.SessionPage;

import static com.codeborne.selenide.Selenide.*;

public class SessionChildrenOldFormPage extends SessionPage {
    private SelenideElement freeSeatButton = $x("//div[@style='color: rgb(255, 255, 255);']");
    private SelenideElement fullDataSession = $x("//div[@class='timeAndPlace']");
    private ElementsCollection tickets = $$x("//div[@class='ticketWrapper desktopTicket']");
    private ElementsCollection ticketsWithoutPlace = $$x("//div[@class='ticketWrapper entryTicketComponent']");

    private SelenideElement sectorOfHall = $("path[stroke='#00bbff']");
    private SelenideElement addTicketButton = $x("//button[@class='button secondary addTicketButton']");

    @Step("Получение текста данных о сеансе с временем, датой и местом проведения из открывшейся формы")
    @Override
    public String getFullDataSessionActual() {
        return fullDataSession.getText();
    }

    @Step("Получение количества выбранных билетов")
    @Override
    public int getTicketQantiti() {
        if (tickeForm == TickeForm.WITH_PLACE) {
            return tickets.size();
        } else {
            return ticketsWithoutPlace.size();
        }
    }
    @Step("Удаление выбранного билета")
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

    public SessionChildrenOldFormPage(String titleExpect, String time, String day, String month, String movieTheatre) {
        super(titleExpect, time, day, month, movieTheatre);
        titleActual = $x("//div[@class='title']");
        makingOrderButtom = $x("//button[@class='button primary']");
    }

    @Step("Клик на свободное место в зале - добавление билета")
    @Override
    public void clickSeatAddTicket() {
        if (addTicketButton.exists()) {
            tickeForm = TickeForm.WITHOUT_PLACE;
            if (ticketsWithoutPlace.size() == plaseInd) {
                addTicketButton.click();
            }
            plaseInd++;
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
